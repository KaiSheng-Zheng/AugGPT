package com.auggpt.model;

import com.unfbx.chatgpt.OpenAiClient;
import com.unfbx.chatgpt.entity.chat.BaseChatCompletion;
import com.unfbx.chatgpt.entity.chat.ChatCompletion;
import com.unfbx.chatgpt.entity.chat.ChatCompletionResponse;
import com.unfbx.chatgpt.entity.chat.Message;
import com.unfbx.chatgpt.function.KeyRandomStrategy;
import dev.ai4j.openai4j.chat.Message;
import dev.langchain4j.data.message.ChatMessage;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class ChatGPTAgent implements Agent {

    private OpenAiClient openAiClient;
    private ArrayList<String> history = new ArrayList<>();
    private static String MODEL = BaseChatCompletion.Model.GPT_4o_MINI.getName(); // Default
    private ChatGPTAgent(){}
    public ChatGPTAgent(String api){
        initializeChatService(api);
    }
    public ChatGPTAgent(String api, String model){
        initializeChatService(api, model);
    }


    /**
     * A wrapper of .chat(String msg) method.
     * @param prompt
     * @param responses
     *      Store previous responses.
     * @param respPointer
     *      Point to the last response of a conversation.(0,2,3) -> (0 for 1st; 1,2 for 2nd; 3 for 3rd)
     * @return
     */
    public synchronized String chat(String prompt,
                                    ArrayList<String> responses,
                                    ArrayList<Integer> respPointer) {
        log.info("Send prompt......");
        ArrayList<String> temp = chat(prompt);
        responses.addAll(temp);
        if(!respPointer.isEmpty())
            respPointer.add(respPointer.get(respPointer.size()-1) + responses.size()-1);
        else
            respPointer.add(responses.size()-1);
        return temp.get(0);
    }

    @Override
    public String reGenerate(String prompt,
                             ArrayList<String> responses,
                             ArrayList<Integer> respPointer) {
        history.remove(history.size()-1);
        return chat(prompt,responses,respPointer);
    }

    @Override
    public String reGenerate(ArrayList<String> responses,
                             ArrayList<Integer> respPointer) {
        String user_msg = history.get(history.size()-2);
//        String gpt_msg = history.get(history.size()-1);

        String prefix = "{role:user,history_content:";
        user_msg = user_msg.substring(user_msg.indexOf(prefix)+prefix.length(),user_msg.lastIndexOf("}"));
        return reGenerate(user_msg,responses,respPointer);
    }

    @Override
    public ArrayList<ChatMessage> getHistory() {
        return history;
    }

    public void initializeChatService(String api){
        openAiClient = OpenAiClient.builder()
                .apiKey(Arrays.asList(api))
                .keyStrategy(new KeyRandomStrategy())
                .apiHost("https://api.chatanywhere.tech")
                .build();
    }
    public void initializeChatService(String api, String model){
        MODEL = model;
        openAiClient = OpenAiClient.builder()
                .apiKey(Arrays.asList(api))
                .keyStrategy(new KeyRandomStrategy())
                .apiHost("https://api.chatanywhere.tech")
                .build();
    }

    private ArrayList<String> chat(String msg){
        if(openAiClient==null){
            try {
                throw new RuntimeException("Please initialize the OpenAI client service");
            }catch (RuntimeException e){
                log.error(e.getMessage(),e);
                return null;
            }
        }

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String today = currentDate.format(formatter);

        Message system_message = Message.builder().role(Message.Role.SYSTEM).content(PromptType.GENERAL_AGENT_SET.getPrompt().replace("<DATE>",today)).build();

        Message message = Message.builder().role(Message.Role.USER).content(history.toString()+"\n\n"+msg).build();
        ChatCompletion chatCompletion = ChatCompletion.builder()
                .messages(List.of(system_message,message))
                .model(MODEL)
                .temperature(0.95)
                .topP(0.75)
                .build();

        ChatCompletionResponse chatCompletionResponse;

        int cnt = 0;
        ArrayList<String> resp = new ArrayList<>();
        while(true) {
            try {
                cnt++;
                chatCompletionResponse = openAiClient.chatCompletion(chatCompletion);
                break;
            } catch (RuntimeException e) {
                log.warn("Timeout",e);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                if (cnt == 20){
                    log.error("Stop retrying, please check your network and configuration.");
                    throw e;
                }
                log.info("Retry...{}",cnt);
            }
        }



        chatCompletionResponse.getChoices().forEach(e -> {
            System.out.println(e.getMessage().getContent());
            resp.add(e.getMessage().getContent());
            history.add(String.format("{role:user,history_content:%s}",msg));
//            history.add(String.format("{role:ChatGPT,history_content:%s}",e.getMessage().getContent()));
        });
        return resp;
    }
    public boolean close(){
        openAiClient = null;
        history = null;
        return true;
    }

}

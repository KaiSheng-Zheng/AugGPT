package com.auggpt.model;

import dev.langchain4j.data.message.AiMessage;
import dev.langchain4j.data.message.ChatMessage;
import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.request.ChatRequestParameters;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.openai.OpenAiChatModel;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class ChatGPTAgentRaw implements Agent {

    private OpenAiChatModel openAiClient;
    private ArrayList<ChatMessage> history = new ArrayList<>();
    private static final String MODEL = AgentType.GPT_4o_MINI_Raw.getName(); // Default
    private static final SystemMessage system_message = SystemMessage.from(PromptType.RAW_AGENT_SET.getPrompt());


    private ChatGPTAgentRaw(){}
    public ChatGPTAgentRaw(String api){
        initializeChatService(api);
    }
    public ChatGPTAgentRaw(String api, String model){
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
        ChatMessage message = history.get(history.size()-1);
        String user_msg = " ";
        if(message instanceof UserMessage){
            user_msg = ((UserMessage) message).singleText();
        }

        String prefix = "{role:user,history_content:";
        user_msg = user_msg.substring(user_msg.indexOf(prefix)+prefix.length(),user_msg.lastIndexOf("}"));
        return reGenerate(user_msg,responses,respPointer);
    }

    @Override
    public ArrayList<ChatMessage> getHistory() {
        return history;
    }

    public void initializeChatService(String api){
        openAiClient = OpenAiChatModel.builder()
                .apiKey(api)
                .defaultRequestParameters(ChatRequestParameters.builder()
                        .modelName(MODEL)
                        .temperature(1.0)
                        .topP(1.0)
                        .build())
                .baseUrl("https://api.chatanywhere.tech")
                .build();
    }
    public void initializeChatService(String api, String model){
        openAiClient = OpenAiChatModel.builder()
                .apiKey(api)
                .defaultRequestParameters(ChatRequestParameters.builder()
                        .modelName(MODEL)
                        .temperature(1.0)
                        .topP(1.0)
                        .build())
                .baseUrl("https://api.chatanywhere.tech")
                .build();
    }

    private ArrayList<String> chat(String msg){
        if(openAiClient==null){
            try {
                throw new RuntimeException("Please initialize OpenAI client service");
            }catch (RuntimeException e){
                log.error(e.getMessage(),e);
                return null;
            }
        }

        UserMessage userMessage = UserMessage.from(msg);

        ChatMessage[] sendMessages = new ChatMessage[history.size()+1];
        sendMessages = history.toArray(sendMessages);
        sendMessages[sendMessages.length-1] = userMessage;

        int cnt = 0;
        ArrayList<String> resp = new ArrayList<>();
        ChatResponse chatResponse;
        while(true) {
            try {
                cnt++;
                chatResponse = openAiClient.chat(sendMessages);
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

        AiMessage responseMsg = chatResponse.aiMessage();
        resp.add(responseMsg.text());
        history.add(userMessage);

        return resp;
    }
    public boolean close(){
        openAiClient = null;
        history = null;
        return true;
    }

}

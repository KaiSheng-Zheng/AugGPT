package com.auggpt.model;

import dev.langchain4j.data.message.ChatMessage;

import java.util.ArrayList;

public interface Agent {

    void initializeChatService(String api);
    String chat(String prompt, ArrayList<String> responses, ArrayList<Integer> respPointer);

    String reGenerate(String prompt,
                      ArrayList<String> responses,
                      ArrayList<Integer> respPointer);
    String reGenerate(ArrayList<String> responses,
                      ArrayList<Integer> respPointer);

    ArrayList<ChatMessage> getHistory();
    boolean close();
}

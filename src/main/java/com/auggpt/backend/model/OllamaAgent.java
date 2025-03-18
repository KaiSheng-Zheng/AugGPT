package com.auggpt.backend.model;

import dev.langchain4j.model.ollama.OllamaChatModel;

public class OllamaAgent extends BaseAgent {
    private static final String MODEL = AgentType.OLLAMA_MODEL.getName(); // Default
    private OllamaAgent(){initializeChatService(null);}
    public OllamaAgent(String url, String model){
        initializeChatService(url, model);
    }

    public void initializeChatService(String url,String model){
        if (url == null || url.isEmpty()) url = "127.0.0.1:11434";
        chatModel = OllamaChatModel.builder()
                .modelName(model)
                .temperature(1.0)
                .topP(1.0)
                .baseUrl(url)
                .build();
    }
    @Override
    public void initializeChatService(String url){
        initializeChatService(url,MODEL);
    }

}

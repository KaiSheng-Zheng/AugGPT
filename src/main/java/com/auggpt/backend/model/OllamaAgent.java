package com.auggpt.backend.model;

import dev.langchain4j.model.ollama.OllamaChatModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

public class OllamaAgent extends BaseAgent {
    private final static Logger log = LogManager.getLogger("Log");
    private static final String MODEL = AgentType.OLLAMA_MODEL.getName(); // Default
    private OllamaAgent(){initializeChatService(null);}
    public OllamaAgent(String url){
        initializeChatService(url);
    }
//    public OllamaAgent(String api, String model){
//        initializeChatService(api, model);
//    }


    public void initializeChatService(String model, String url){
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
        initializeChatService(MODEL,url);
    }

}

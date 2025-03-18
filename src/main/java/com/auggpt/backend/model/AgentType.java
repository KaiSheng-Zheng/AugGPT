package com.auggpt.backend.model;


public enum AgentType {

    GPT_4o_MINI(1003, "gpt-4o-mini"),
    CLAUDE(1021,"claude-3-5-haiku-latest"),
    CLAUDE_SONNET(1022,"claude-3-7-sonnet-latest"),
    DEEPSEEK(1031,"deepseek-chat"),
    QWEN(1041,"qwen-turbo"),
    QWEN_MAX(1043,"qwen-max"),

    //no system prompt
//    GPT_4o_MINI_Raw(2003, "gpt-4o-mini"),
    OLLAMA_MODEL(2001,"your ollama model");
    final int code;
    final String name;
    AgentType(int code,String name){
        this.code = code;
        this.name = name;
    }

    public int getCode(){
        return code;
    }
    public String getName(){
        return name;
    }
}

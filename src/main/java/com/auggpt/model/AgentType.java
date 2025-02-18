package com.auggpt.model;


public enum AgentType {

    GPT_4o_MINI(1003, "gpt-4o-mini"),

    //no system prompt
    GPT_4o_MINI_Raw(2003, "gpt-4o-mini");
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

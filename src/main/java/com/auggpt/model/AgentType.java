package com.auggpt.model;

import com.unfbx.chatgpt.entity.chat.BaseChatCompletion;


public enum AgentType {

    GPT_3_5_TURBO_1106(1001, BaseChatCompletion.Model.GPT_3_5_TURBO_1106.getName()),
    GPT_3_5_TURBO_0125(1002, BaseChatCompletion.Model.GPT_3_5_TURBO_0125.getName()),
    GPT_4o_MINI(1003, BaseChatCompletion.Model.GPT_4o_MINI.getName()),

    //no system prompt
    GPT_4o_MINI_Raw(2003, BaseChatCompletion.Model.GPT_4o_MINI.getName());
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

package com.auggpt.utils;

import com.auggpt.model.PromptType;

import java.util.List;

public class PromptUtils {
    private PromptUtils(){}
    public static String prompting(List<String> raw, PromptType type){
        String prompt = type.getPrompt();
        for (int i = 0; i < raw.size(); i++) {
            prompt = prompt.replace("[REPLACE_"+i+"]", raw.get(i));
        }
        return prompt;
    }
}

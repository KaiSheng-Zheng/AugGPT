package com.auggpt.model;

import com.unfbx.chatgpt.entity.chat.Message;

public enum CoverageMetrics {
    INSTRUCTION("instructions"),BRANCH("branches");
    final String name;

    CoverageMetrics(String name){
        this.name = name;
    }
}

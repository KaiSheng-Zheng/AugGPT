package com.unfbx.chatgpt.entity.chat.tool;

import lombok.*;

import java.io.Serializable;



@Data
public class ToolChoice implements Serializable {

    @Getter
    @AllArgsConstructor
    public enum Choice {
        NONE("none"),
        AUTO("auto"),
        ;
        private final String name;
    }
}

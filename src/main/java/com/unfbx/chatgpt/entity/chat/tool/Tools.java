package com.unfbx.chatgpt.entity.chat.tool;


import lombok.*;

import java.io.Serializable;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tools implements Serializable {

    

    private String type;

    private ToolsFunction function;

    @Getter
    @AllArgsConstructor
    public enum Type {
        FUNCTION("function"),
        ;
        private final String name;
    }
}

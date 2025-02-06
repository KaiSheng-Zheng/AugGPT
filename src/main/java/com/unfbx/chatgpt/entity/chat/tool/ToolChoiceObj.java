package com.unfbx.chatgpt.entity.chat.tool;

import lombok.*;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ToolChoiceObj {
    

    private ToolChoiceObjFunction function;
    

    private String type;

    @Getter
    @AllArgsConstructor
    public enum Type {
        FUNCTION("function"),
        ;
        private final String name;
    }
}

package com.unfbx.chatgpt.entity.chat;

import lombok.*;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseFormat {


    private String type;

    @Getter
    @AllArgsConstructor
    public enum Type {
        JSON_OBJECT("json_object"),
        TEXT("text"),
        ;
        private final String name;
    }
}

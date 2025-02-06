package com.unfbx.chatgpt.entity.assistant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.unfbx.chatgpt.entity.chat.Functions;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Data
@Slf4j
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Tool implements Serializable {

    private String type;

    

    private Functions function;


    

    @Getter
    @AllArgsConstructor
    public enum Type {
        CODE_INTERPRETER("code_interpreter"),
        RETRIEVAL("retrieval"),
        FUNCTION("function"),
        ;
        private final String name;
    }
}

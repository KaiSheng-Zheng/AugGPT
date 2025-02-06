package com.unfbx.chatgpt.entity.assistant.run;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;
import java.util.Map;




@Data
@Slf4j
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ToolCall implements Serializable {
    

    private String id;
    

    private String type;

    

    @JsonProperty("code_interpreter")
    private CodeInterpreter codeInterpreter;

    

    @JsonProperty("retrieval")
    private Map retrieval;

    @JsonProperty("function")
    private Function function;

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

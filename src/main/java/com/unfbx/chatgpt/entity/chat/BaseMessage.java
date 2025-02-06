package com.unfbx.chatgpt.entity.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unfbx.chatgpt.entity.chat.tool.ToolCalls;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;



@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class BaseMessage implements Serializable {

    

    private String role;


    private String name;

    

    @JsonProperty("tool_calls")
    private List<ToolCalls> toolCalls;

    

    @JsonProperty("tool_call_id")
    private String toolCallId;

    @Deprecated
    @JsonProperty("function_call")
    private FunctionCall functionCall;


    

    public BaseMessage(String role, String name, FunctionCall functionCall) {
        this.role = role;
        this.name = name;
        this.functionCall = functionCall;
    }

    public BaseMessage() {
    }


    @Getter
    @AllArgsConstructor
    public enum Role {

        SYSTEM("system"),
        USER("user"),
        ASSISTANT("assistant"),
        FUNCTION("function"),
        TOOL("tool"),
        ;
        private final String name;
    }

}

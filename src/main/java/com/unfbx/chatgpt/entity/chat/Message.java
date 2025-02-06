package com.unfbx.chatgpt.entity.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.unfbx.chatgpt.entity.chat.tool.ToolCalls;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;



@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
public class Message extends BaseMessage implements Serializable {


    private String content;

    public static Builder builder() {
        return new Builder();
    }



    public Message(String role, String name, String content, List<ToolCalls> toolCalls, String toolCallId, FunctionCall functionCall) {
        this.content = content;
        super.setRole(role);
        super.setName(name);
        super.setToolCalls(toolCalls);
        super.setToolCallId(toolCallId);
        super.setFunctionCall(functionCall);
    }

    public Message() {
    }

    private Message(Builder builder) {
        setContent(builder.content);
        super.setRole(builder.role);
        super.setName(builder.name);
        super.setFunctionCall(builder.functionCall);
        super.setToolCalls(builder.toolCalls);
        super.setToolCallId(builder.toolCallId);
    }

    public static final class Builder {
        private String role;
        private String content;
        private String name;
        private String toolCallId;
        private List<ToolCalls> toolCalls;
        private FunctionCall functionCall;

        public Builder() {
        }

        public Builder role(Role role) {
            this.role = role.getName();
            return this;
        }

        public Builder role(String role) {
            this.role = role;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder functionCall(FunctionCall functionCall) {
            this.functionCall = functionCall;
            return this;
        }

        public Builder toolCalls(List<ToolCalls> toolCalls) {
            this.toolCalls = toolCalls;
            return this;
        }

        public Builder toolCallId(String toolCallId) {
            this.toolCallId = toolCallId;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}

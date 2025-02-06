package com.unfbx.chatgpt.entity.chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;



@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChatChoice implements Serializable {

    private long index;
    

    @JsonProperty("delta")
    private Message delta;
    

    @JsonProperty("message")
    private Message message;
    @JsonProperty("finish_reason")
    private String finishReason;
}

package com.unfbx.chatgpt.entity.whisper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;



@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WhisperResponse implements Serializable {

    private String text;
}

package com.unfbx.chatgpt.entity.whisper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;



@Data
public class Whisper implements Serializable {


    @Getter
    @AllArgsConstructor
    public enum Model {
        WHISPER_1("whisper-1"),
        ;
        private final String name;
    }

    @Getter
    @AllArgsConstructor
    public enum ResponseFormat {
        JSON("json"),
        TEXT("text"),
        SRT("srt"),
        VERBOSE_JSON("verbose_json"),
        VTT("vtt"),
        ;
        private final String name;
    }
}

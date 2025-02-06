package com.unfbx.chatgpt.entity.images;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;



@Data
@Slf4j
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class Image implements Serializable {

    

    private String prompt;
    

    @Builder.Default
    private String model = Model.DALL_E_3.getName();

    

    private String quality;

    

    private Integer n;
    

    private String size;
    

    private String style;

    

    @JsonProperty("response_format")
    private String responseFormat;

    private String user;

    

    @Getter
    @AllArgsConstructor
    public enum Model {
        DALL_E_2("dall-e-2"),
        DALL_E_3("dall-e-3"),
        ;
        private final String name;
    }

    

    @Getter
    @AllArgsConstructor
    public enum Quality {
        STANDARD("standard"),
        HD("hd"),
        ;
        private final String name;
    }

    

    @Getter
    @AllArgsConstructor
    public enum Style {
        VIVID("vivid"),
        NATURAL("natural"),
        ;
        private final String name;
    }
}

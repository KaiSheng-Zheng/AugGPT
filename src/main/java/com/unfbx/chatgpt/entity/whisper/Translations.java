package com.unfbx.chatgpt.entity.whisper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldNameConstants;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Translations {
    

    @Builder.Default
    private String model = Whisper.Model.WHISPER_1.getName();
    

    private String prompt;
    

    @JsonProperty("response_format")
    @Builder.Default
    private String responseFormat = Whisper.ResponseFormat.JSON.getName();
    

    @Builder.Default
    private double temperature = 0;

}

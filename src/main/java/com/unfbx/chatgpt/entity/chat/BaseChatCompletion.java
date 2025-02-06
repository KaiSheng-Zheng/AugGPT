package com.unfbx.chatgpt.entity.chat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unfbx.chatgpt.entity.chat.tool.Tools;
import com.unfbx.chatgpt.entity.chat.tool.ToolChoice;
import com.unfbx.chatgpt.entity.chat.tool.ToolChoiceObj;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.List;
import java.util.Map;



@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class BaseChatCompletion implements Serializable {

    @NonNull
    @Builder.Default
    private String model = Model.GPT_4o_MINI.getName();

    

    @JsonProperty("response_format")
    private ResponseFormat responseFormat;

    

    @Deprecated
    private List<Functions> functions;

    

    @Deprecated
    @JsonProperty("function_call")
    private Object functionCall;

    

    private List<Tools> tools;

    

    @JsonProperty("tool_choice")
    private Object toolChoice;

    

    @Builder.Default
    private double temperature = 0.6;

    

    @JsonProperty("top_p")
    @Builder.Default
    private Double topP = 0.7d;


    

    @Builder.Default
    private Integer n = 1;


    

    @Builder.Default
    private boolean stream = false;
    

    private List<String> stop;
    

    @JsonProperty("max_tokens")
    @Builder.Default
    private Integer maxTokens = 16384;


    @JsonProperty("presence_penalty")
    @Builder.Default
    private double presencePenalty = 0;

    

    @JsonProperty("frequency_penalty")
    @Builder.Default
    private double frequencyPenalty = 0;

    @JsonProperty("conversation_max_tokens")
    @Builder.Default
    private int conversation_max_tokens = 12000;

    @JsonProperty("logit_bias")
    private Map logitBias;
    

    private String user;

    

    private Integer seed;


    

    @Getter
    @AllArgsConstructor
    public enum Model {
        

        GPT_3_5_TURBO("gpt-3.5-turbo"),
//        

//        @Deprecated
//        GPT_3_5_TURBO_0301("gpt-3.5-turbo-0301"),
        

        GPT_3_5_TURBO_0613("gpt-3.5-turbo-0613"),
        

        GPT_3_5_TURBO_16K("gpt-3.5-turbo-16k"),
        

        GPT_3_5_TURBO_16K_0613("gpt-3.5-turbo-16k-0613"),
        

        GPT_3_5_TURBO_1106("gpt-3.5-turbo-1106"),
        GPT_3_5_TURBO_0125("gpt-3.5-turbo-0125"),
        

        GPT_4("gpt-4"),
//        

//        @Deprecated
//        GPT_4_0314("gpt-4-0314"),
        

        GPT_4_32K("gpt-4-32k"),
//        

//        @Deprecated
//        GPT_4_32K_0314("gpt-4-32k-0314"),

        

        GPT_4_0613("gpt-4-0613"),
        

        GPT_4_32K_0613("gpt-4-32k-0613"),
        

        GPT_4_1106_PREVIEW("gpt-4-1106-preview"),
        

        GPT_4_VISION_PREVIEW("gpt-4-vision-preview"),

        GPT_4o_MINI("gpt-4o-mini")
        ;
        private final String name;
    }

}

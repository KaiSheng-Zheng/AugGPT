package com.unfbx.chatgpt.entity.completions;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unfbx.chatgpt.utils.TikTokensUtil;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.*;



@Data
@Builder
@Slf4j
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class Completion implements Serializable {

    @NonNull
    @Builder.Default
    private String model = Model.DAVINCI_003.getName();
    

    @NonNull
    private String prompt;
    

    private String suffix;

    

    @JsonProperty("max_tokens")
    @Builder.Default
    private Integer maxTokens = 16000;
    

    @Builder.Default
    private double temperature = 0.2;

    

    @JsonProperty("top_p")
    @Builder.Default
    private Double topP = 1d;

    

    @Builder.Default
    private Integer n = 1;

    @Builder.Default
    private boolean stream = false;
    

    private Integer logprobs;

    @Builder.Default
    private boolean echo = false;

    private List<String> stop;

    @JsonProperty("presence_penalty")
    @Builder.Default
    private double presencePenalty = 0;

    

    @JsonProperty("frequency_penalty")
    @Builder.Default
    private double frequencyPenalty = 0;

    @JsonProperty("best_of")
    @Builder.Default
    private Integer bestOf = 1;

    @JsonProperty("logit_bias")
    private Map logitBias;
    

    private Integer seed;

    

    private String user;

    

    public long tokens() {
        if (StrUtil.isBlank(this.prompt) || StrUtil.isBlank(this.model)) {
            log.warn(" Parameter exception model: {}，prompt: {}", this.model, this.prompt);
            return 0;
        }
        return TikTokensUtil.tokens(this.model, this.prompt);
    }

    @Getter
    @AllArgsConstructor
    public enum Model {
        DAVINCI_003("text-davinci-003"),
        DAVINCI_002("text-davinci-002"),
        DAVINCI("davinci"),
        ;
        private final String name;
    }
}

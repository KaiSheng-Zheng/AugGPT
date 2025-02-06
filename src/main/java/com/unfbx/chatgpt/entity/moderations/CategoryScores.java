package com.unfbx.chatgpt.entity.moderations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;



@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryScores implements Serializable {
    private BigDecimal hate;
    @JsonProperty("hate/threatening")
    private BigDecimal hateThreatening;
    @JsonProperty("self-harm")
    private BigDecimal selfHarm;
    private BigDecimal sexual;
    @JsonProperty("sexual/minors")
    private BigDecimal sexualMinors;
    private BigDecimal violence;
    @JsonProperty("violence/graphic")
    private BigDecimal violenceGraphic;

    

    @JsonProperty("harassment")
    private BigDecimal harassment;
    

    @JsonProperty("harassment/threatening")
    private BigDecimal harassmentThreatening;
    

    @JsonProperty("self-harm/intent")
    private BigDecimal selfHarmIntent;
    

    @JsonProperty("self-harm/instructions")
    private BigDecimal selfHarmInstructions;
}

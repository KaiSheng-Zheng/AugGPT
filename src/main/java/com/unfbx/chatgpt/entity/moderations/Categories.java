package com.unfbx.chatgpt.entity.moderations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;



@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Categories implements Serializable {
    

    private boolean hate;
    

    @JsonProperty("hate/threatening")
    private boolean hateThreatening;
    

    @JsonProperty("self-harm")
    private boolean selfHarm;
    

    private boolean sexual;
    

    @JsonProperty("sexual/minors")
    private boolean sexualMinors;
    

    private boolean violence;
    

    @JsonProperty("violence/graphic")
    private boolean violenceGraphic;
    

    @JsonProperty("harassment")
    private boolean harassment;
    

    @JsonProperty("harassment/threatening")
    private boolean harassmentThreatening;
    

    @JsonProperty("self-harm/intent")
    private boolean selfHarmIntent;
    

    @JsonProperty("self-harm/instructions")
    private boolean selfHarmInstructions;
}

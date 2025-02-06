package com.unfbx.chatgpt.entity.billing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;



@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Datum {
    private String object;
    private String id;
    

    @JsonProperty("grant_amount")
    private BigDecimal grantAmount;
    

    @JsonProperty("used_amount")
    private BigDecimal usedAmount;
    

    @JsonProperty("effective_at")
    private Long effectiveAt;
    

    @JsonProperty("expires_at")
    private Long expiresAt;
}

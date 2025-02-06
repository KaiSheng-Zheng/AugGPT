package com.unfbx.chatgpt.entity.billing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;



@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreditGrantsResponse implements Serializable {
    private String object;
    

    @JsonProperty("total_granted")
    private BigDecimal totalGranted;
    

    @JsonProperty("total_used")
    private BigDecimal totalUsed;
    

    @JsonProperty("total_available")
    private BigDecimal totalAvailable;
    

    private Grants grants;
}

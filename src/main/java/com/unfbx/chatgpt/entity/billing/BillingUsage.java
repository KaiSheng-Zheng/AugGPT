package com.unfbx.chatgpt.entity.billing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;



@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingUsage {

    @JsonProperty("object")
    private String object;
    

    @JsonProperty("daily_costs")
    private List<DailyCost> dailyCosts;
    

    @JsonProperty("total_usage")
    private BigDecimal totalUsage;

}

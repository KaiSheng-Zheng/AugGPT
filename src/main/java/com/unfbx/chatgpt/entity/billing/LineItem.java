package com.unfbx.chatgpt.entity.billing;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;



@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LineItem {
    

    private String name;
    

    private BigDecimal cost;
}

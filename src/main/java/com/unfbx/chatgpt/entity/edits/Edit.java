package com.unfbx.chatgpt.entity.edits;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;



@Data
@Builder
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Deprecated
public class Edit implements Serializable {
    

    @NonNull
    private String model;

    @NonNull
    private String input;
    

    @NonNull
    private String instruction;


    

    @Builder.Default
    private double temperature = 0.2;

    

    @JsonProperty("top_p")
    @Builder.Default
    private Double topP = 1d;

    

    @Builder.Default
    private Integer n = 1;

    public void setModel(Model model) {
        this.model = model.getName();
    }

    public void setTemperature(double temperature) {
        if (temperature > 2 || temperature < 0) {
            log.error("temperature Parameter exception ，temperature belong to [0,2]");
            this.temperature = 2;
            return;
        }
        this.temperature = temperature;
    }


    public void setTopP(Double topP) {
        this.topP = topP;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
    @Getter
    @AllArgsConstructor
    public enum Model {
        TEXT_DAVINCI_EDIT_001("text-davinci-edit-001"),
        CODE_DAVINCI_EDIT_001("code-davinci-edit-001"),
        ;
        private final String name;
    }
}

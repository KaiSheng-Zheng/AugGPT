package com.unfbx.chatgpt.entity.assistant.run;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unfbx.chatgpt.entity.assistant.Tool;
import com.unfbx.chatgpt.entity.assistant.thread.Thread;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;
import java.util.Map;



@Data
@Slf4j
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class ThreadRun implements Serializable {
    @JsonProperty("assistant_id")
    private String assistantId;

    private Thread thread;

    private String model;
    

    private String instructions;

    

    private List<Tool> tools;

    

    private Map metadata;

}

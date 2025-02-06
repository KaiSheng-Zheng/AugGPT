package com.unfbx.chatgpt.entity.assistant;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssistantResponse implements Serializable {

    private String id;
    private String object;


    private String model;


    private String name;


    private String description;


    private String instructions;


    private List<Tool> tools;


    @JsonProperty("file_ids")
    private List<String> fileIds;


    private Map metadata;
    

    @JsonProperty("created_at")
    private Long createdAt;


}

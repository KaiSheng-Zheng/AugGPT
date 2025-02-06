package com.unfbx.chatgpt.entity.assistant.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unfbx.chatgpt.entity.assistant.Tool;
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
public class MessageResponse implements Serializable {

    private String id;

    private String object;
    

    @JsonProperty("created_at")
    private Long createdAt;

    @JsonProperty("thread_id")
    private String threadId;

    private String role;
    

    private List<Content> content;

    @JsonProperty("assistant_id")
    private String assistantId;

    @JsonProperty("run_id")
    private String runId;

    

    @JsonProperty("file_ids")
    private List<String> fileIds;

    

    private Map metadata;
}

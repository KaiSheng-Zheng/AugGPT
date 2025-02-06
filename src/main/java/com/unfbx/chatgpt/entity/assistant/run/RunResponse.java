package com.unfbx.chatgpt.entity.assistant.run;

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
public class RunResponse implements Serializable {

    private String id;
    private String object;
    

    @JsonProperty("created_at")
    private Long createdAt;

    @JsonProperty("thread_id")
    private String threadId;

    @JsonProperty("assistant_id")
    private String assistantId;

    

    private String status;

    @JsonProperty("required_action")
    private Action requiredAction;

    

    @JsonProperty("last_error")
    private RunError lastError;

    @JsonProperty("expires_at")
    private Long expiresAt;

    @JsonProperty("started_at")
    private Long startedAt;

    @JsonProperty("cancelled_at")
    private Long cancelledAt;

    @JsonProperty("failed_at")
    private Long failedAt;

    @JsonProperty("completed_at")
    private Long completedAt;
    

    private String model;
    

    private String instructions;
    

    private List<Tool> tools;
    

    @JsonProperty("file_ids")
    private List<String> fileIds;
    

    private Map metadata;

    @Getter
    @AllArgsConstructor
    public enum Status {
        QUEUED("queued", " line up "),
        IN_PROGRESS("in_progress", " have in hand "),
        REQUIRE_ACTION("require_action", " Need to operate "),
        CANCELLING("cancelling", " cancel "),
        CANCELLED("cancelled", " Cancelled "),
        FAILED("failed", " fail "),
        COMPLETED("completed", " Completed "),
        EXPIRED("expired", " Expired  "),
        ;
        private final String name;
        private final String desc;
    }
}

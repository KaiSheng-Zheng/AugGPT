package com.unfbx.chatgpt.entity.assistant.run;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Map;



@Data
@Slf4j
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class RunStepResponse implements Serializable {

    private String id;
    private String object;
    

    @JsonProperty("created_at")
    private Long createdAt;

    @JsonProperty("assistant_id")
    private String assistantId;

    @JsonProperty("thread_id")
    private String threadId;

    @JsonProperty("run_id")
    private String runId;

    

    private String type;

    

    private String status;

    @JsonProperty("step_details")
    private StepDetail stepDetails;

    

    @JsonProperty("last_error")
    private RunError lastError;

    @JsonProperty("expires_at")
    private Long expiresAt;

    @JsonProperty("cancelled_at")
    private Long cancelledAt;

    @JsonProperty("failed_at")
    private Long failedAt;

    @JsonProperty("completed_at")
    private Long completedAt;

    

    private Map metadata;

    @Getter
    @AllArgsConstructor
    public enum Status {
        IN_PROGRESS("in_progress", " have in hand "),
        CANCELLED("cancelled", " Cancelled "),
        FAILED("failed", " fail "),
        COMPLETED("completed", " Completed "),
        EXPIRED("expired", " Expired  "),
        ;
        private final String name;
        private final String desc;
    }

    @Getter
    @AllArgsConstructor
    public enum Type {
        MESSAGE_CREATION("message_creation"),
        TOOL_CALLS("tool_calls"),
        ;
        private final String name;
    }
}

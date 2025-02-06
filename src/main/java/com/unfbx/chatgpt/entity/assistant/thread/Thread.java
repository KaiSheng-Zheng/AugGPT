package com.unfbx.chatgpt.entity.assistant.thread;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class Thread implements Serializable {

    

    private List<ThreadMessage> messages;
    

    private Map metadata;
}

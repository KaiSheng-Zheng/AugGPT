package com.unfbx.chatgpt.entity.assistant.run;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class ModifyRun implements Serializable {

    

    private Map metadata;
}

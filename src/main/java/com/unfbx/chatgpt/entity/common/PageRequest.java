package com.unfbx.chatgpt.entity.common;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Getter
@Slf4j
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest {

    

    private Integer limit;
    

    private String order;
    

    private String before;
    

    private String after;


    

    @Getter
    @AllArgsConstructor
    public enum Order {
        DESC("desc"),
        ASC("asc"),
        ;
        private final String name;
    }
}

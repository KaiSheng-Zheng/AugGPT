package com.unfbx.chatgpt.entity.assistant.message;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;



@Data
@Slf4j
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Annotations {

    private String type;

    private String text;

    

    @JsonProperty("file_citation")
    private FileCitation fileCitation;

    

    @JsonProperty("file_path")
    private FilePath filePath;

    @JsonProperty("start_index")
    private Integer startIndex;

    @JsonProperty("end_index")
    private Integer endIndex;


    

    @Getter
    @AllArgsConstructor
    public enum Type {
        FILE_CITATION("file_citation"),
        FILE_PATH("file_path"),
        ;
        private final String name;
    }
}

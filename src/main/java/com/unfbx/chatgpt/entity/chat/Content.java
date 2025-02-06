package com.unfbx.chatgpt.entity.chat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.extern.slf4j.Slf4j;



@Data
@Builder
@Slf4j
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class Content {
    

    private String type;
    private String text;
    @JsonProperty("image_url")
    private ImageUrl imageUrl;

    

    @Getter
    @AllArgsConstructor
    public enum Type {
        TEXT("text"),
        IMAGE_URL("image_url"),
        ;
        private final String name;
    }
}

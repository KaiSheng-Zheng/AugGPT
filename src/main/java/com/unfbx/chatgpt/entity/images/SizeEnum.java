package com.unfbx.chatgpt.entity.images;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;



@Getter
@AllArgsConstructor
public enum SizeEnum implements Serializable {
    size_1024_1792("1024x1792"),
    size_1792_1024("1792x1024"),
    size_1024("1024x1024"),
    size_512("512x512"),
    size_256("256x256"),

    ;
    private final String name;

}

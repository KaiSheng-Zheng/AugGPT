package com.unfbx.chatgpt.entity.images;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unfbx.chatgpt.exception.BaseException;
import com.unfbx.chatgpt.exception.CommonError;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Objects;



@Getter
@Slf4j
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class ImageEdit implements Serializable {
    

    @NonNull
    private String prompt;
    

    @Builder.Default
    private Integer n = 1;
    

    @Builder.Default
    private String size = SizeEnum.size_512.getName();

    @JsonProperty("response_format")
    @Builder.Default
    private String responseFormat = ResponseFormat.URL.getName();

    private String user;

    public ImageEdit setN(Integer n) {
        if(n < 1){
            log.warn("n minimum value 1");
            n = 1;
        }
        if(n > 10){
            log.warn("n Maximum value 10");
            n = 10;
        }
        this.n = n;
        return this;
    }

    public ImageEdit setPrompt(String prompt) {
        if(StrUtil.isEmpty(prompt)){
            log.error(" Parameter exception ");
            throw new BaseException(CommonError.PARAM_ERROR);
        }
        if(prompt.length() > 1000){
            log.error(" Length exceeds 1000");
            throw new BaseException(CommonError.PARAM_ERROR);
        }
        this.prompt = prompt;
        return this;
    }

    public ImageEdit setSize(SizeEnum size) {
        if(Objects.isNull(size)){
            size = SizeEnum.size_512;
        }
        this.size = size.getName();
        return this;
    }

    public ImageEdit setResponseFormat(ResponseFormat responseFormat) {
        if(Objects.isNull(responseFormat)){
            responseFormat = ResponseFormat.URL;
        }
        this.responseFormat = responseFormat.getName();
        return this;
    }

    public ImageEdit setUser(String user) {
        this.user = user;
        return this;
    }


}

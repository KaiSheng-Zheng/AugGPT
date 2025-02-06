package com.unfbx.chatgpt.entity.chat;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.unfbx.chatgpt.utils.TikTokensUtil;
import lombok.*;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.List;



@Data
@SuperBuilder
@Slf4j
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class ChatCompletion extends BaseChatCompletion implements Serializable {

    

    @NonNull
    private List<Message> messages;



    public long tokens() {
        if (CollectionUtil.isEmpty(this.messages) || StrUtil.isBlank(this.getModel())) {
            log.warn(" Parameter exception model: {}，prompt: {}", this.getModel(), this.messages);
            return 0;
        }
        return TikTokensUtil.tokens(this.getModel(), this.messages);
    }
}

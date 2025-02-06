
package com.unfbx.chatgpt.interceptor;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.http.ContentType;
import cn.hutool.http.Header;
import com.unfbx.chatgpt.exception.BaseException;
import com.unfbx.chatgpt.exception.CommonError;
import com.unfbx.chatgpt.function.KeyStrategyFunction;
import lombok.Getter;
import lombok.Setter;
import okhttp3.Interceptor;
import okhttp3.Request;

import java.util.List;
import java.util.Map;

public abstract class OpenAiAuthInterceptor implements Interceptor {


    

    @Getter
    @Setter
    private List<String> apiKey;
    

    @Getter
    @Setter
    private KeyStrategyFunction<List<String>, String> keyStrategy;

    

    @Getter
    @Setter
    private Map warringConfig;

    

    protected abstract List<String> onErrorDealApiKeys(String errorKey);

    

    protected abstract void noHaveActiveKeyWarring();


    

    public final String getKey() {
        if (CollectionUtil.isEmpty(apiKey)) {
            this.noHaveActiveKeyWarring();
            throw new BaseException(CommonError.NO_ACTIVE_API_KEYS);
        }
        return keyStrategy.apply(apiKey);
    }

    

    public Request auth(String key, Request original) {
        return original.newBuilder()
                .header(Header.AUTHORIZATION.getValue(), "Bearer " + key)
                .header(Header.CONTENT_TYPE.getValue(), ContentType.JSON.getValue())
                .method(original.method(), original.body())
                .build();
    }
}

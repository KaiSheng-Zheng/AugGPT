package com.unfbx.chatgpt.interceptor;

import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.Map;



@Slf4j
public class DefaultOpenAiAuthInterceptor extends OpenAiAuthInterceptor {
    

    public DefaultOpenAiAuthInterceptor() {
        super.setWarringConfig(null);
    }

    

    public DefaultOpenAiAuthInterceptor(Map warringConfig) {
        super.setWarringConfig(warringConfig);
    }

    

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        return chain.proceed(auth(super.getKey(), original));
    }

    

    @Override
    protected List<String> onErrorDealApiKeys(String apiKey) {
        return super.getApiKey();
    }

    @Override
    protected void noHaveActiveKeyWarring() {
        log.error("--------> [give an alarm] No availablekey！！！");
        return;
    }
}

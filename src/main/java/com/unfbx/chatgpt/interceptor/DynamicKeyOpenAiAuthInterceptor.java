package com.unfbx.chatgpt.interceptor;

import cn.hutool.json.JSONUtil;
import com.unfbx.chatgpt.entity.common.OpenAiResponse;
import com.unfbx.chatgpt.exception.BaseException;
import com.unfbx.chatgpt.exception.CommonError;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;



@Getter
@Slf4j
public class DynamicKeyOpenAiAuthInterceptor extends OpenAiAuthInterceptor {
    

    private static final String ACCOUNT_DEACTIVATED = "account_deactivated";
    

    private static final String INVALID_API_KEY = "invalid_api_key";

    

    public DynamicKeyOpenAiAuthInterceptor() {
        this.setWarringConfig(null);
    }

    

    public DynamicKeyOpenAiAuthInterceptor(Map warringConfig) {
        this.setWarringConfig(warringConfig);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        String key = getKey();
        Request original = chain.request();
        Request request = this.auth(key, original);
        Response response = chain.proceed(request);
        if (!response.isSuccessful() && response.body() != null) {
            String errorMsg = response.body().string();
            if (response.code() == CommonError.OPENAI_AUTHENTICATION_ERROR.code()
                    || response.code() == CommonError.OPENAI_LIMIT_ERROR.code()
                    || response.code() == CommonError.OPENAI_SERVER_ERROR.code()) {
                OpenAiResponse openAiResponse = JSONUtil.toBean(errorMsg, OpenAiResponse.class);
                String errorCode = openAiResponse.getError().getCode();
                log.error("--------> request openai exception，error code: {}", errorCode);
                log.error("--------> Request error: {}", errorMsg);
                // Account banned or key If it's incorrect, remove it 
                if (ACCOUNT_DEACTIVATED.equals(errorCode) || INVALID_API_KEY.equals(errorCode)) {
                    super.setApiKey(this.onErrorDealApiKeys(key));
                }
                throw new BaseException(openAiResponse.getError().getMessage());
            }
            // Unofficial definition error code
            log.error("--------> Request exception: {}", errorMsg);
            OpenAiResponse openAiResponse = JSONUtil.toBean(errorMsg, OpenAiResponse.class);
            if (Objects.nonNull(openAiResponse.getError())) {
                log.error(openAiResponse.getError().getMessage());
                throw new BaseException(openAiResponse.getError().getMessage());
            }
            throw new BaseException(CommonError.RETRY_ERROR);
        }
        return response;
    }


    @Override
    protected List<String> onErrorDealApiKeys(String errorKey) {
        List<String> apiKey = super.getApiKey().stream().filter(e -> !errorKey.equals(e)).collect(Collectors.toList());
        log.error("--------> currentApiKey: [{}] Invalid，remove！", errorKey);
        return apiKey;
    }

    

    @Override
    protected void noHaveActiveKeyWarring() {
        log.error("--------> [give an alarm] No availablekey！！！");
        return;
    }

    @Override
    public Request auth(String key, Request original) {
        return super.auth(key, original);
    }
}

package com.unfbx.chatgpt;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.ContentType;
import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.unfbx.chatgpt.constant.OpenAIConst;
import com.unfbx.chatgpt.entity.Tts.TextToSpeech;
import com.unfbx.chatgpt.entity.billing.BillingUsage;
import com.unfbx.chatgpt.entity.billing.CreditGrantsResponse;
import com.unfbx.chatgpt.entity.billing.Subscription;
import com.unfbx.chatgpt.entity.chat.*;
import com.unfbx.chatgpt.entity.common.OpenAiResponse;
import com.unfbx.chatgpt.entity.completions.Completion;
import com.unfbx.chatgpt.exception.BaseException;
import com.unfbx.chatgpt.exception.CommonError;
import com.unfbx.chatgpt.function.KeyRandomStrategy;
import com.unfbx.chatgpt.function.KeyStrategyFunction;
import com.unfbx.chatgpt.interceptor.DefaultOpenAiAuthInterceptor;
import com.unfbx.chatgpt.interceptor.DynamicKeyOpenAiAuthInterceptor;
import com.unfbx.chatgpt.interceptor.OpenAiAuthInterceptor;
import com.unfbx.chatgpt.plugin.PluginAbstract;
import com.unfbx.chatgpt.plugin.PluginParam;
import com.unfbx.chatgpt.sse.ConsoleEventSourceListener;
import com.unfbx.chatgpt.sse.DefaultPluginListener;
import com.unfbx.chatgpt.sse.PluginListener;
import io.reactivex.Single;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;
import okhttp3.sse.EventSources;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;





@Slf4j
public class OpenAiStreamClient {
    @Getter
    @NotNull
    private List<String> apiKey;
    

    @Getter
    private String apiHost;
    

    @Getter
    private OkHttpClient okHttpClient;

    

    @Getter
    private KeyStrategyFunction<List<String>, String> keyStrategy;

    @Getter
    private OpenAiApi openAiApi;

    

    @Getter
    private OpenAiAuthInterceptor authInterceptor;

    

    private OpenAiStreamClient(Builder builder) {
        if (CollectionUtil.isEmpty(builder.apiKey)) {
            throw new BaseException(CommonError.API_KEYS_NOT_NUL);
        }
        apiKey = builder.apiKey;

        if (StrUtil.isBlank(builder.apiHost)) {
            builder.apiHost = OpenAIConst.OPENAI_HOST;
        }
        apiHost = builder.apiHost;

        if (Objects.isNull(builder.keyStrategy)) {
            builder.keyStrategy = new KeyRandomStrategy();
        }
        keyStrategy = builder.keyStrategy;

        if (Objects.isNull(builder.authInterceptor)) {
            builder.authInterceptor = new DefaultOpenAiAuthInterceptor();
        }
        authInterceptor = builder.authInterceptor;
        // set up apiKeys and key The acquisition strategy 
        authInterceptor.setApiKey(this.apiKey);
        authInterceptor.setKeyStrategy(this.keyStrategy);

        if (Objects.isNull(builder.okHttpClient)) {
            builder.okHttpClient = this.okHttpClient();
        } else {
            // Customized okhttpClient   Need to increase api keys
            builder.okHttpClient = builder.okHttpClient
                    .newBuilder()
                    .addInterceptor(authInterceptor)
                    .build();
        }
        okHttpClient = builder.okHttpClient;

        this.openAiApi = new Retrofit.Builder()
                .baseUrl(apiHost)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build().create(OpenAiApi.class);
    }

    

    private OkHttpClient okHttpClient() {
        if (Objects.isNull(this.authInterceptor)) {
            this.authInterceptor = new DefaultOpenAiAuthInterceptor();
        }
        this.authInterceptor.setApiKey(this.apiKey);
        this.authInterceptor.setKeyStrategy(this.keyStrategy);
        return new OkHttpClient
                .Builder()
                .addInterceptor(this.authInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(50, TimeUnit.SECONDS)
                .readTimeout(50, TimeUnit.SECONDS)
                .build();
    }

    

    public void streamCompletions(Completion completion, EventSourceListener eventSourceListener) {
        if (Objects.isNull(eventSourceListener)) {
            log.error(" Parameter exception : EventSourceListener Cannot be empty ， You can refer to : com.unfbx.chatgpt.sse.ConsoleEventSourceListener");
            throw new BaseException(CommonError.PARAM_ERROR);
        }
        if (StrUtil.isBlank(completion.getPrompt())) {
            log.error(" Parameter exception : Prompt Cannot be empty ");
            throw new BaseException(CommonError.PARAM_ERROR);
        }
        if (!completion.isStream()) {
            completion.setStream(true);
        }
        try {
            EventSource.Factory factory = EventSources.createFactory(this.okHttpClient);
            ObjectMapper mapper = new ObjectMapper();
            String requestBody = mapper.writeValueAsString(completion);
            Request request = new Request.Builder()
                    .url(this.apiHost + "v1/completions")
                    .post(RequestBody.create(MediaType.parse(ContentType.JSON.getValue()), requestBody))
                    .build();
            // Create event 
            EventSource eventSource = factory.newEventSource(request, eventSourceListener);
        } catch (JsonProcessingException e) {
            log.error(" Request parameter parsing exception : {}", e);
            e.printStackTrace();
        } catch (Exception e) {
            log.error(" Request parameter parsing exception : {}", e);
            e.printStackTrace();
        }
    }

    

    public void streamCompletions(String question, EventSourceListener eventSourceListener) {
        Completion q = Completion.builder()
                .prompt(question)
                .stream(true)
                .build();
        this.streamCompletions(q, eventSourceListener);
    }

    

    public <T extends BaseChatCompletion> void streamChatCompletion(T chatCompletion, EventSourceListener eventSourceListener) {
        if (Objects.isNull(eventSourceListener)) {
            log.error(" Parameter exception : EventSourceListener Cannot be empty ， You can refer to : com.unfbx.chatgpt.sse.ConsoleEventSourceListener");
            throw new BaseException(CommonError.PARAM_ERROR);
        }
        if (!chatCompletion.isStream()) {
            chatCompletion.setStream(true);
        }
        try {
            EventSource.Factory factory = EventSources.createFactory(this.okHttpClient);
            ObjectMapper mapper = new ObjectMapper();
            String requestBody = mapper.writeValueAsString(chatCompletion);
            Request request = new Request.Builder()
                    .url(this.apiHost + "v1/chat/completions")
                    .post(RequestBody.create(MediaType.parse(ContentType.JSON.getValue()), requestBody))
                    .build();
            // Create event 
            EventSource eventSource = factory.newEventSource(request, eventSourceListener);
        } catch (JsonProcessingException e) {
            log.error(" Request parameter parsing exception : {}", e);
            e.printStackTrace();
        } catch (Exception e) {
            log.error(" Request parameter parsing exception : {}", e);
            e.printStackTrace();
        }
    }

    

    public void streamChatCompletion(List<Message> messages, EventSourceListener eventSourceListener) {
        ChatCompletion chatCompletion = ChatCompletion.builder()
                .messages(messages)
                .stream(true)
                .build();
        this.streamChatCompletion(chatCompletion, eventSourceListener);
    }


    

    public <R extends PluginParam, T> void streamChatCompletionWithPlugin(ChatCompletion chatCompletion, EventSourceListener eventSourceListener, PluginListener pluginEventSourceListener, PluginAbstract<R, T> plugin) {
        if (Objects.isNull(plugin)) {
            this.streamChatCompletion(chatCompletion, eventSourceListener);
            return;
        }
        if (CollectionUtil.isEmpty(chatCompletion.getMessages())) {
            throw new BaseException(CommonError.MESSAGE_NOT_NUL);
        }
        Functions functions = Functions.builder()
                .name(plugin.getFunction())
                .description(plugin.getDescription())
                .parameters(plugin.getParameters())
                .build();
        // No value ， Set default values 
        if (Objects.isNull(chatCompletion.getFunctionCall())) {
            chatCompletion.setFunctionCall("auto");
        }
        //tip:  Overwrite your own settings functions parameter ， use plugin Constructed functions
        chatCompletion.setFunctions(Collections.singletonList(functions));
        // call OpenAi
        if (Objects.isNull(pluginEventSourceListener)) {
            pluginEventSourceListener = new DefaultPluginListener(this, eventSourceListener, plugin, chatCompletion);
        }
        this.streamChatCompletion(chatCompletion, pluginEventSourceListener);
    }


    

    public <R extends PluginParam, T> void streamChatCompletionWithPlugin(ChatCompletion chatCompletion, EventSourceListener eventSourceListener, PluginAbstract<R, T> plugin) {
        PluginListener pluginEventSourceListener = new DefaultPluginListener(this, eventSourceListener, plugin, chatCompletion);
        this.streamChatCompletionWithPlugin(chatCompletion, eventSourceListener, pluginEventSourceListener, plugin);
    }


    

    public <R extends PluginParam, T> void streamChatCompletionWithPlugin(List<Message> messages, EventSourceListener eventSourceListener, PluginAbstract<R, T> plugin) {
        this.streamChatCompletionWithPlugin(messages, ChatCompletion.Model.GPT_3_5_TURBO_16K_0613.getName(), eventSourceListener, plugin);
    }

    

    public <R extends PluginParam, T> void streamChatCompletionWithPlugin(List<Message> messages, String model, EventSourceListener eventSourceListener, PluginAbstract<R, T> plugin) {
        ChatCompletion chatCompletion = ChatCompletion.builder().messages(messages).model(model).build();
        this.streamChatCompletionWithPlugin(chatCompletion, eventSourceListener, plugin);
    }

    

    @SneakyThrows
    @Deprecated
    public CreditGrantsResponse creditGrants() {
        Request request = new Request.Builder()
                .url(this.apiHost + "dashboard/billing/credit_grants")
                .get()
                .build();
        Response response = this.okHttpClient.newCall(request).execute();
        ResponseBody body = response.body();
        String bodyStr = body.string();
//        log.info(" Call to query balance request return value : {}", bodyStr);
        if (!response.isSuccessful()) {
            if (response.code() == CommonError.OPENAI_AUTHENTICATION_ERROR.code()
                    || response.code() == CommonError.OPENAI_LIMIT_ERROR.code()
                    || response.code() == CommonError.OPENAI_SERVER_ERROR.code()) {
                OpenAiResponse openAiResponse = JSONUtil.toBean(bodyStr, OpenAiResponse.class);
                log.error(openAiResponse.getError().getMessage());
                throw new BaseException(openAiResponse.getError().getMessage());
            }
            log.error(" Abnormal balance inquiry request : {}", bodyStr);
            OpenAiResponse openAiResponse = JSONUtil.toBean(bodyStr, OpenAiResponse.class);
            if (Objects.nonNull(openAiResponse.getError())) {
                log.error(openAiResponse.getError().getMessage());
                throw new BaseException(openAiResponse.getError().getMessage());
            }
            throw new BaseException(CommonError.RETRY_ERROR);
        }
        ObjectMapper mapper = new ObjectMapper();
        //  read Json  Return value 
        return mapper.readValue(bodyStr, CreditGrantsResponse.class);
    }

    

    public Subscription subscription() {
        Single<Subscription> subscription = this.openAiApi.subscription();
        return subscription.blockingGet();
    }

    

    public BillingUsage billingUsage(@NotNull LocalDate starDate, @NotNull LocalDate endDate) {
        Single<BillingUsage> billingUsage = this.openAiApi.billingUsage(starDate, endDate);
        return billingUsage.blockingGet();
    }

    

    public static OpenAiStreamClient.Builder builder() {
        return new OpenAiStreamClient.Builder();
    }

    public static final class Builder {
        private @NotNull List<String> apiKey;
        

        private String apiHost;

        

        private OkHttpClient okHttpClient;


        

        private KeyStrategyFunction keyStrategy;

        

        private OpenAiAuthInterceptor authInterceptor;

        public Builder() {
        }

        public Builder apiKey(@NotNull List<String> val) {
            apiKey = val;
            return this;
        }

        

        public Builder apiHost(String val) {
            apiHost = val;
            return this;
        }

        public Builder keyStrategy(KeyStrategyFunction val) {
            keyStrategy = val;
            return this;
        }

        public Builder okHttpClient(OkHttpClient val) {
            okHttpClient = val;
            return this;
        }

        public Builder authInterceptor(OpenAiAuthInterceptor val) {
            authInterceptor = val;
            return this;
        }

        public OpenAiStreamClient build() {
            return new OpenAiStreamClient(this);
        }
    }
}

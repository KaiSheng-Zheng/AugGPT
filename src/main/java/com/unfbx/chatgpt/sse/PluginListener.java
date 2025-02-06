package com.unfbx.chatgpt.sse;

import cn.hutool.json.JSONUtil;
import com.unfbx.chatgpt.OpenAiStreamClient;
import com.unfbx.chatgpt.entity.chat.ChatCompletion;
import com.unfbx.chatgpt.entity.chat.ChatCompletionResponse;
import com.unfbx.chatgpt.entity.chat.FunctionCall;
import com.unfbx.chatgpt.entity.chat.Message;
import com.unfbx.chatgpt.plugin.PluginAbstract;
import com.unfbx.chatgpt.plugin.PluginParam;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;



@Slf4j
public abstract class PluginListener<R extends PluginParam, T> extends EventSourceListener {
    

    private String arguments = "";

    

    private String getArguments() {
        return this.arguments;
    }

    private OpenAiStreamClient client;
    private EventSourceListener eventSourceListener;
    private PluginAbstract<R, T> plugin;
    private ChatCompletion chatCompletion;

    

    public PluginListener(OpenAiStreamClient client, EventSourceListener eventSourceListener, PluginAbstract<R, T> plugin, ChatCompletion chatCompletion) {
        this.client = client;
        this.eventSourceListener = eventSourceListener;
        this.plugin = plugin;
        this.chatCompletion = chatCompletion;
    }

    

    public void onClosedAfter() {
        log.debug(" Method value of construction : {}", getArguments());

        R realFunctionParam = (R) JSONUtil.toBean(getArguments(), plugin.getR());
        T tq = plugin.func(realFunctionParam);

        FunctionCall functionCall = FunctionCall.builder()
                .arguments(getArguments())
                .name(plugin.getFunction())
                .build();
        chatCompletion.getMessages().add(Message.builder().role(Message.Role.ASSISTANT).content("function_call").functionCall(functionCall).build());
        chatCompletion.getMessages().add(Message.builder().role(Message.Role.FUNCTION).name(plugin.getFunction()).content(plugin.content(tq)).build());
        // Set up the second time ， Parameters requested 
        chatCompletion.setFunctionCall(null);
        chatCompletion.setFunctions(null);
        client.streamChatCompletion(chatCompletion, eventSourceListener);
    }


    @Override
    public final void onEvent(EventSource eventSource, String id, String type, String data) {
        log.debug(" Plugin development returns information collection sse The listener returns data : {}", data);
        if ("[DONE]".equals(data)) {
            log.debug(" Plugin development returns information collection sse The data returned by the listener has ended ");
            return;
        }
        ChatCompletionResponse chatCompletionResponse = JSONUtil.toBean(data, ChatCompletionResponse.class);
        if (Objects.nonNull(chatCompletionResponse.getChoices().get(0).getDelta().getFunctionCall())) {
            this.arguments += chatCompletionResponse.getChoices().get(0).getDelta().getFunctionCall().getArguments();
        }
    }

    @Override
    public final void onClosed(EventSource eventSource) {
        log.debug(" Plugin development returns information collection sse The listener closes the connection ...");
        this.onClosedAfter();
    }

    @Override
    public void onOpen(EventSource eventSource, Response response) {
        log.debug(" Plugin development returns information collection sse Monitor establishes connection ...");
    }

    @SneakyThrows
    @Override
    public void onFailure(EventSource eventSource, Throwable t, Response response) {
        if (Objects.isNull(response)) {
            log.error(" Plugin development returns information collection sse monitor , Connection exception :{}", t);
            eventSource.cancel();
            return;
        }
        ResponseBody body = response.body();
        if (Objects.nonNull(body)) {
            log.error(" Plugin development returns information collection sse monitor , Connection exception data: {}， abnormal : {}", body.string(), t);
        } else {
            log.error(" Plugin development returns information collection sse monitor , Connection exception data: {}， abnormal : {}", response, t);
        }
        eventSource.cancel();
    }
}

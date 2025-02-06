package com.unfbx.chatgpt.sse;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;

import java.util.Objects;



@Slf4j
public class ConsoleEventSourceListener extends EventSourceListener {

    @Override
    public void onOpen(EventSource eventSource, Response response) {
        log.info("OpenAI establish sse connect ...");
    }

    @Override
    public void onEvent(EventSource eventSource, String id, String type, String data) {
        log.info("OpenAI Return data : {}", data);
        if ("[DONE]".equals(data)) {
            log.info("OpenAI The return of data has ended ");
            return;
        }
    }

    @Override
    public void onClosed(EventSource eventSource) {
        log.info("OpenAI close sse connect ...");
    }

    @SneakyThrows
    @Override
    public void onFailure(EventSource eventSource, Throwable t, Response response) {
        if(Objects.isNull(response)){
            log.error("OpenAI  sse Connection exception :{}", t);
            eventSource.cancel();
            return;
        }
        ResponseBody body = response.body();
        if (Objects.nonNull(body)) {
            log.error("OpenAI  sse Connection exception data: {}， abnormal : {}", body.string(), t);
        } else {
            log.error("OpenAI  sse Connection exception data: {}， abnormal : {}", response, t);
        }
        eventSource.cancel();
    }
}

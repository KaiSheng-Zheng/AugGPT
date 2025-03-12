package com.auggpt.backend.utils;

import org.apache.logging.log4j.core.*;
import org.apache.logging.log4j.core.appender.AbstractAppender;
import org.apache.logging.log4j.core.config.plugins.Plugin;
import org.apache.logging.log4j.core.config.plugins.PluginAttribute;
import org.apache.logging.log4j.core.config.plugins.PluginElement;
import org.apache.logging.log4j.core.config.plugins.PluginFactory;
import org.apache.logging.log4j.core.layout.PatternLayout;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 自定义 ListAppender，用于捕获日志事件并存储在内存中。
 */
@Plugin(name = "ListAppender", category = Core.CATEGORY_NAME, elementType = Appender.ELEMENT_TYPE, printObject = true)
public class ListAppender extends AbstractAppender {

    private final BlockingQueue<String> logEvents = new ArrayBlockingQueue<>(10000);

    protected ListAppender(String name, Filter filter, Layout<? extends Serializable> layout, boolean ignoreExceptions) {
        super(name, filter, layout, ignoreExceptions);
    }

    @Override
    public void append(LogEvent event) {
        // 将日志事件添加到列表中
        logEvents.add(String.valueOf(getLayout().toSerializable(event)));
    }

    public BlockingQueue<String> getLogEvents() {
        return logEvents;
    }

    public void clear() {
        logEvents.clear();
    }

    /**
     * 创建 ListAppender 的工厂方法。
     */
    @PluginFactory
    public static ListAppender createAppender(
            @PluginAttribute("name") String name,
            @PluginElement(Layout.ELEMENT_TYPE) PatternLayout layout) {
        if (name == null) {
            LOGGER.error("Name cannot be null");
            return null;
        }
        if (layout == null) {
            layout = PatternLayout.newBuilder().withPattern("%d{yyyy-MM-dd HH:mm:ss} [%t] %-5level - %msg%n").build();
        }
        return new ListAppender(name,null,layout,true);
    }
}

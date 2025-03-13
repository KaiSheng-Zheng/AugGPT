package com.auggpt.backend.utils;


import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 自定义 ListAppender，用于捕获日志事件并存储在内存中。
 */
//@Plugin(name = "ListAppender", category = Core.CATEGORY_NAME, elementType = Appender.ELEMENT_TYPE, printObject = true)
public class ListAppender extends AppenderSkeleton {

    private final BlockingQueue<String> logEvents = new ArrayBlockingQueue<>(10000);

    public ListAppender(){
        super();
    }
    public ListAppender(Layout layout){
        setLayout(layout);
    }

//    public ListAppender(String name, Filter filter, Layout layout, boolean ignoreExceptions) {
//        super();
//    }

    @Override
    public void append(LoggingEvent event) {
        // 将日志事件添加到列表中
        logEvents.add(String.valueOf(getLayout().format(event)));
    }

    public BlockingQueue<String> getLogEvents() {
        return logEvents;
    }

    public void clear() {
        logEvents.clear();
    }

    @Override
    public void close() {
        clear();
    }

    @Override
    public boolean requiresLayout() {
        return true;
    }

//    /**
//     * 创建 ListAppender 的工厂方法。
//     */
//    @PluginFactory
//    public static ListAppender createAppender(
//            @PluginAttribute("name") String name,
//            @PluginElement(Layout.ELEMENT_TYPE) PatternLayout layout) {
//        if (name == null) {
//            LOGGER.error("Name cannot be null");
//            return null;
//        }
//        if (layout == null) {
//            layout = PatternLayout.newBuilder().withPattern("%d{yyyy-MM-dd HH:mm:ss} [%t] %-5level - %msg%n").build();
//        }
//        return new ListAppender(name,null,layout,true);
//    }
}

package com.auggpt.backend.utils;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * log4j2的日志捕获器
 */
public class Log4j2CapturerUtils {

    private static ListAppender listAppender;

    /**
     * 开始捕获指定类的日志。
     *
     * @param name 要捕获日志的名字
     */
    public static void captureLogs(String name) {
        // 1. 获取 Logger
        Logger logger = LogManager.getLogger(name);

        // 2. 创建 ListAppender 并设置布局
        listAppender = new ListAppender();
        listAppender.setLayout(
                new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} [%t] %-5p - %m%n"));
//"%d{yyyy-MM-dd}-%t-%x-%-5p-%-10c:%m%n"
        // 3. 清空之前的日志
        listAppender.clear();

        // 4. 设置 Logger 的附加属性为 false，避免日志重复输出
        logger.setAdditivity(false);

        // 5. 将 MemoryAppender 添加到 Logger
        logger.addAppender(listAppender);
    }

    /**
     * 停止捕获日志并移除 MemoryAppender。
     */
    public static void stopCapture() {
        if (listAppender != null) {
            // 1. 获取 Logger
            Logger logger = LogManager.getLogger(Log4j2CapturerUtils.class.getName());

            // 2. 移除 MemoryAppender
            logger.removeAppender(listAppender);

            // 3. 停止 MemoryAppender
            listAppender.close();
            listAppender = null;
        }
    }

    /**
     * 获取所有捕获的日志（格式化后的字符串）。
     *
     * @return 捕获到的日志列表
     */
    public static BlockingQueue<String> getCapturedLogs() {
        if (listAppender == null) {
            System.out.println(1);
            return new ArrayBlockingQueue<>(10000);

        }
        // 4. 获取日志事件并格式化为字符串
        return listAppender.getLogEvents();
    }


    /**
     * 止捕获日志并移除 ListAppender
     * 然后所有捕获的日志（格式化后的字符串）。
     *
     * @return 捕获到的日志列表
     */
    public static List<String> getCapturedLogsAndStopCapture() {
        BlockingQueue<String> collect = listAppender.getLogEvents();
        stopCapture();
        return new ArrayList<>(collect);
    }

}

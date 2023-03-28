package com.kapcb.context.util;

import com.kapcb.context.configuration.ThreadFactoryConfiguration;
import com.kapcb.context.core.ApplicationContextHolder;
import com.kapcb.context.properties.AsyncExecutorProperties;
import lombok.experimental.UtilityClass;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <a>Title: ThreadPoolExecutorUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ThreadPoolExecutorUtil <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/19 21:43
 * @since 1.0
 */
@UtilityClass
public class ThreadPoolExecutorUtil {

    private static volatile AsyncExecutorProperties executorProperties;

    /**
     * 获取自定义线程池
     *
     * @return ThreadPoolExecutor
     */
    public static ThreadPoolExecutor getThreadPool() {
        AsyncExecutorProperties executorProperties = getExecutorProperties();
        return new ThreadPoolExecutor(executorProperties.getCorePoolSize(),
                executorProperties.getMaxPoolSize(),
                executorProperties.getKeepAliveTime(),
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(executorProperties.getQueueCapacity()),
                new ThreadFactoryConfiguration());
    }

    private static AsyncExecutorProperties getExecutorProperties() {
        if (Objects.isNull(executorProperties)) {
            synchronized (ThreadPoolExecutorUtil.class) {
                if (Objects.isNull(executorProperties)) {
                    executorProperties = ApplicationContextHolder.getBean(AsyncExecutorProperties.class);
                }
            }
        }
        return executorProperties;
    }

}

package kapcb.framework.web.util;

import kapcb.framework.web.configuration.ThreadFactoryConfiguration;
import kapcb.framework.web.context.ApplicationContextProvider;
import kapcb.framework.web.properties.ExecutorProperties;
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
 * @version 1.0.0
 * @date 2021/11/21 12:47
 */
@UtilityClass
public class ThreadPoolExecutorUtil {

    private static volatile ExecutorProperties executorProperties;

    /**
     * 获取自定义线程池
     *
     * @return ThreadPoolExecutor
     */
    public static ThreadPoolExecutor getThreadPool() {
        ExecutorProperties executorProperties = getExecutorProperties();
        return new ThreadPoolExecutor(executorProperties.getCorePoolSize(),
                executorProperties.getMaxPoolSize(),
                executorProperties.getKeepAliveTime(),
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(executorProperties.getQueueCapacity()),
                new ThreadFactoryConfiguration());
    }

    private static ExecutorProperties getExecutorProperties() {
        if (Objects.isNull(executorProperties)) {
            synchronized (ThreadPoolExecutorUtil.class) {
                if (Objects.isNull(executorProperties)) {
                    executorProperties = ApplicationContextProvider.getBean(ExecutorProperties.class);
                }
            }
        }
        return executorProperties;
    }
}

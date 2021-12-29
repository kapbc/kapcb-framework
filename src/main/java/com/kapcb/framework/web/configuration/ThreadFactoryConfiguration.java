package com.kapcb.framework.web.configuration;

import com.kapcb.framework.common.constants.enums.IntegerPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <a>Title: ThreadFactoryConfiguration </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ThreadFactoryConfiguration <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/21 12:40
 */
@Slf4j
@Configuration
public class ThreadFactoryConfiguration implements ThreadFactory {

    private static final AtomicInteger POOL_NUM = new AtomicInteger(IntegerPool.ONE.value());
    private final ThreadGroup threadGroup;
    private final String threadNamePrefix;
    private final AtomicInteger threadNumber = new AtomicInteger(IntegerPool.ONE.value());

    public ThreadFactoryConfiguration() {
        this("kapcb-pool");
    }

    public ThreadFactoryConfiguration(String name) {
        SecurityManager securityManager = System.getSecurityManager();
        this.threadGroup = Objects.nonNull(securityManager) ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
        // 此时 threadNamePrefix 就是 name + 第几个用这个工厂创建线程池的
        this.threadNamePrefix = name + POOL_NUM.getAndIncrement();
    }


    @Override
    public Thread newThread(Runnable r) {
        // 此时 threadNamePrefix 就是 name + 第几个用这个工厂创建线程池的
        Thread thread = new Thread(threadGroup, threadNamePrefix + "-thread-" + threadNumber.getAndIncrement());
        if (thread.isDaemon()) {
            thread.setDaemon(false);
        }
        if (!Objects.equals(thread.getPriority(), Thread.NORM_PRIORITY)) {
            thread.setPriority(Thread.NORM_PRIORITY);
        }
        return thread;
    }

}

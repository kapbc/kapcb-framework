package com.kapcb.framework.web.configuration;

import com.kapcb.framework.web.properties.AsyncExecutorProperties;
import com.kapcb.framework.web.executor.CustomThreadPoolTaskExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <a>Title: executorConfiguration </a>
 * <a>Author: Kapcb <a>
 * <a>Description: executorConfiguration <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/18 21:35
 */
@Slf4j
@Order(-1)
@EnableAsync
@Configuration
@EnableConfigurationProperties(value = {AsyncExecutorProperties.class})
@ConditionalOnProperty(value = "kapcb.async.enable", havingValue = "true", matchIfMissing = true)
public class AsyncConfiguration implements AsyncConfigurer {

    @Resource
    private TaskDecorator taskDecorator;

    @Resource
    private AsyncExecutorProperties asyncExecutorProperties;

    @Bean("asyncExecutor")
    public ThreadPoolTaskExecutor asyncExecutor() {
        log.info("[ begin to create async executor ]");
        CustomThreadPoolTaskExecutor executor = new CustomThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(asyncExecutorProperties.getCorePoolSize());
        // 最大线程数
        executor.setMaxPoolSize(asyncExecutorProperties.getMaxPoolSize());
        // 队列大小
        executor.setQueueCapacity(asyncExecutorProperties.getQueueCapacity());
        // 线程池名的前缀
        executor.setThreadNamePrefix(asyncExecutorProperties.getThreadPrefix());
        // 允许线程的空闲时间
        executor.setKeepAliveSeconds(asyncExecutorProperties.getKeepAliveTime());
        // rejection-policy 当pool达到max size的时候, 处理新任务的策略
        // CALLER_RUNS 不在新线程中执行, 而是调用者所在线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 应用关闭时-是否等待未完成任务继续执行，再继续销毁其他的Bean
        executor.setWaitForTasksToCompleteOnShutdown(asyncExecutorProperties.getWaitForTasksToCompleteOnShutdown());
        // 应用关闭时-继续等待时间（单位：秒）
        executor.setAwaitTerminationMillis(asyncExecutorProperties.getAwaitTerminationMillis());
        // 是否允许核心线程超时
        executor.setAllowCoreThreadTimeOut(asyncExecutorProperties.getAllowCoreThreadTimeOut());
        // 异步线程上下文装饰器
        executor.setTaskDecorator(taskDecorator);
        // 执行初始化
        executor.initialize();
        return executor;
    }

    @Override
    public Executor getAsyncExecutor() {
        return asyncExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (e, method, param) -> log.error(String.format("run async task '%s'", method), e);
    }
}
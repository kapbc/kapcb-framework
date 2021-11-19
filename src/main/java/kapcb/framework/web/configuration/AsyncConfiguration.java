package kapcb.framework.web.configuration;

import kapcb.framework.web.concurrent.CustomThreadPoolTaskExecutor;
import kapcb.framework.web.properties.ExecutorProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurer;
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
@EnableConfigurationProperties(value = {ExecutorProperties.class})
@ConditionalOnProperty(value = "kapcb.async.enable", havingValue = "true", matchIfMissing = true)
public class AsyncConfiguration implements AsyncConfigurer {

    @Resource
    private ExecutorProperties executorProperties;

    @Bean("asyncExecutor")
    public ThreadPoolTaskExecutor executor() {
        CustomThreadPoolTaskExecutor executor = new CustomThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(executorProperties.getCorePoolSize());
        // 最大线程数
        executor.setMaxPoolSize(executorProperties.getMaxPoolSize());
        // 队列大小
        executor.setQueueCapacity(executorProperties.getQueueCapacity());
        // 线程池中的线程名称前缀
        executor.setThreadNamePrefix(executorProperties.getThreadPrefix());
        // 线程活跃时间
        executor.setKeepAliveSeconds(executorProperties.getKeepAliveTime());
        // rejection-policy 当pool达到max size的时候, 处理新任务的策略
        // CALLER_RUNS 不在新线程中执行, 而是调用者所在线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 等待所有任务执行玩之后关闭
        executor.setWaitForTasksToCompleteOnShutdown(executorProperties.getWaitForTasksToCompleteOnShutdown());

        executor.setAwaitTerminationMillis(executorProperties.getAwaitTerminationMillis());
        // 执行初始化
        executor.initialize();
        return executor;
    }

    @Override
    public Executor getAsyncExecutor() {
        return executor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return (e, method, param) -> log.error(String.format("run async task '%s'", method), e);
    }

}

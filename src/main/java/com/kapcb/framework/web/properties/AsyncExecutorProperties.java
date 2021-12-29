package com.kapcb.framework.web.properties;

import com.kapcb.framework.web.enums.RejectedExecutionHandlerPolicyEnum;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <a>Title: AsyncExecutorProperties </a>
 * <a>Author: Kapcb <a>
 * <a>Description: AsyncExecutorProperties <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 13:45
 */
@Data
@ConfigurationProperties(prefix = "kapcb.async")
public class AsyncExecutorProperties {

    /**
     * 是否开启异步线程池
     */
    private Boolean enable = Boolean.FALSE;

    /**
     * 线程池创建时候初始化的线程数
     */
    private Integer corePoolSize = 5;

    /**
     * 线程池最大的线程数，只有在缓冲队列满了之后才会申请超过核心线程数的线程
     */
    private Integer maxPoolSize = 5;

    /**
     * 当核心线程数达到最大时，新任务会放在队列中排队等待执行
     */
    private Integer queueCapacity = 999;

    /**
     * 当超过了核心线程数之外的线程在空闲时间到达之后会被销毁
     */
    private Integer keepAliveTime = 30;

    /**
     * 应用关闭时-是否等待未完成任务继续执行，再继续销毁其他的Bean
     */
    private Boolean waitForTasksToCompleteOnShutdown = true;

    /**
     * 是否允许核心线程超时
     */
    private Boolean allowCoreThreadTimeOut = false;

    /**
     * 如果超过这个时间还没有销毁就强制销毁，以确保应用最后能够被关闭，而不是阻塞住
     */
    private Integer awaitTerminationMillis = 5;

    /**
     * 设置好了之后可以方便我们定位处理任务所在的线程池
     */
    private String threadPrefix = "kapcb-async-executor-";

    /**
     * 线程池拒绝策略
     * 不在新线程中执行, 而是调用者所在线程来执行
     * 默认 : {@linkplain RejectedExecutionHandlerPolicyEnum#CALLER_RUNS_POLICY}
     */
    private RejectedExecutionHandlerPolicyEnum rejectedExecutionHandlerPolicy = RejectedExecutionHandlerPolicyEnum.CALLER_RUNS_POLICY;

}

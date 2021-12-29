package com.kapcb.framework.web.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <a>Title: RejectedExecutionHandlerPolicyEnum </a>
 * <a>Author: Kapcb <a>
 * <a>Description: RejectedExecutionHandlerPolicyEnum <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2021/12/29 22:54
 * @since 1.0
 */
@Getter
@AllArgsConstructor
public enum RejectedExecutionHandlerPolicyEnum {

    /**
     * 当线程池的所有线程都已经被占用时抛出 {@link java.util.concurrent.RejectedExecutionException} 异常。
     */
    ABORT_POLICY(new ThreadPoolExecutor.AbortPolicy()),

    /**
     * 当线程池的所有线程都已经被占用时，将由原始线程来执行任务（若原始线程已关闭将直接丢弃任务）。
     */
    CALLER_RUNS_POLICY(new ThreadPoolExecutor.CallerRunsPolicy()),

    /**
     * 当线程池的所有线程都已经被占用时，它丢弃最古老的未处理请求，然后重试执行（若执行程序已关闭将直接丢弃任务）。
     */
    DISCARD_OLDEST_POLICY(new ThreadPoolExecutor.DiscardOldestPolicy()),

    /**
     * 当线程池的所有线程都已经被占用时，将悄悄地丢弃被拒绝的任务。
     */
    DISCARD_POLICY(new ThreadPoolExecutor.DiscardPolicy());

    RejectedExecutionHandler rejectedExecutionHandler;

}

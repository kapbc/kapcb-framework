package com.kapcb.framework.web.executor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * <a>Title: CustomThreadPoolTaskExecutor </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CustomThreadPoolTaskExecutor <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/18 21:43
 */
@Slf4j
public class CustomThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {

    private static final long serialVersionUID = -2272267038851573575L;

    private void showDetail(String prefix) {
        ThreadPoolExecutor executor = getThreadPoolExecutor();
        if (log.isDebugEnabled()) {
            log.debug("{}{}, task count : [{}], complete task count : [{}], active count : [{}], queue capacity : [{}]",
                    this.getDefaultThreadNamePrefix(),
                    prefix,
                    executor.getTaskCount(),
                    executor.getCompletedTaskCount(),
                    executor.getActiveCount(),
                    executor.getQueue().size());
        }
    }

    @Override
    public void execute(Runnable task) {
        showDetail("1. do execute");
        super.execute(task);
    }

    @Override
    public void execute(Runnable task, long startTimeout) {
        showDetail("2. do execute");
        super.execute(task, startTimeout);
    }

    @Override
    public Future<?> submit(Runnable task) {
        showDetail("1. do submit");
        return super.submit(task);
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        showDetail("2. do submit");
        return super.submit(task);
    }

    @Override
    public ListenableFuture<?> submitListenable(Runnable task) {
        showDetail("1. do submitListenable");
        return super.submitListenable(task);
    }

    @Override
    public <T> ListenableFuture<T> submitListenable(Callable<T> task) {
        showDetail("2. do submitListenable");
        return super.submitListenable(task);
    }

}

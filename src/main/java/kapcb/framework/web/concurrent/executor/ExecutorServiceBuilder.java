package kapcb.framework.web.concurrent.executor;

import kapcb.framework.web.properties.ExecutorProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * <a>Title: ExecutorServiceBuilder </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 13:44
 */
@Slf4j
@RequiredArgsConstructor
@EnableConfigurationProperties(value = {ExecutorProperties.class})
@ConditionalOnProperty(value = "kapcb.executor.service.autoConfigure", havingValue = "true", matchIfMissing = true)
public class ExecutorServiceBuilder {

    private final ExecutorProperties executorProperties;

    private static ExecutorService executorService = null;

    public ExecutorService getInstance() {
        log.info("get executor instance....");
        if (executorService == null) {
            synchronized (this) {
                executorService = new ThreadPoolExecutor(
                        executorProperties.getCorePoolSize(),
                        executorProperties.getMaxPoolSize(),
                        executorProperties.getKeepAliveTime(),
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(executorProperties.getQueueCapacity()),
                        Executors.defaultThreadFactory(),
                        new ThreadPoolExecutor.CallerRunsPolicy());
            }
        }
        return executorService;
    }
}
package com.kapcb.framework.web.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <a>Title: ExecutorProperties </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 13:45
 */
@Data
@ConfigurationProperties(prefix = "kapcb.async")
public class ExecutorProperties {

    private Boolean enable = Boolean.FALSE;

    private Integer corePoolSize = 5;

    private Integer maxPoolSize = 5;

    private Integer queueCapacity = 999;

    private Integer keepAliveTime = 30;

    private Boolean waitForTasksToCompleteOnShutdown = true;

    private Integer awaitTerminationMillis = 5;

    private String threadPrefix = "kapcb-async-executor-";
}

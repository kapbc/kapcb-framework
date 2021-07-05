package kapcb.framework.web.properties;

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
@ConfigurationProperties(prefix = "kapcb.executor.service")
public class ExecutorProperties {

    private boolean autoConfigure = Boolean.FALSE;

    private int corePoolSize = 10;

    private int maxPoolSize = 20;

    private int queueCapacity = 999;

    private int keepAliveTime = 30;

    private String threadPrefix = "kapcb-executor-service-";
}

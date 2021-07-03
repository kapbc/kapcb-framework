package kapcb.framework.web.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <a>Title: RedissonProperties </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 13:45
 */
@ConfigurationProperties(prefix = "kapcb.redis.redisson", ignoreInvalidFields = true)
public class RedissonProperties {

    private Boolean autoConfigure = false;

    private String address;

}
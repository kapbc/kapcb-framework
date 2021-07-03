package kapcb.framework.web.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <a>Title: RedisLettuceProperties </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 14:21
 */
@Data
@ConfigurationProperties(value = "kapcb.redis.lettuce",ignoreInvalidFields = true)
public class RedisLettuceProperties {

    private Boolean autoConfigure = false;
}
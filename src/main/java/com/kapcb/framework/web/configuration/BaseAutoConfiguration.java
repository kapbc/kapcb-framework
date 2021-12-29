package com.kapcb.framework.web.configuration;

import com.kapcb.framework.web.context.ApplicationContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <a>Title: BaseAutoConfiguration </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BaseAutoConfiguration <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2021/12/29 22:20
 * @since 1.0
 */
@Slf4j
@Configuration
public class BaseAutoConfiguration {

    @Bean("applicationContextHolder")
    @ConditionalOnMissingBean(value = {ApplicationContextHolder.class})
    public ApplicationContextHolder applicationContextHolder() {
        return new ApplicationContextHolder();
    }


}

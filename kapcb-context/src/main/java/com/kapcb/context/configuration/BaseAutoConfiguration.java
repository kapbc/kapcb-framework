package com.kapcb.context.configuration;

import com.kapcb.context.core.ApplicationContextHolder;
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
 * @date 2023/3/19 21:44
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

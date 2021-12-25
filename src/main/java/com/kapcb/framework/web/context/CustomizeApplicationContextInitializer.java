package com.kapcb.framework.web.context;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

/**
 * <a>Title: CustomizeApplicationContextInitializer </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CustomizeApplicationContextInitializer <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2021/12/25 14:13
 * @since 1.0
 */
public abstract class CustomizeApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {

    private static final Logger log = LoggerFactory.getLogger(CustomizeApplicationContextInitializer.class);

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

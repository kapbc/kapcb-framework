package com.kapcb.context.core;

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
 * @date 2023/3/19 21:36
 * @since 1.0
 */
public class CustomizeApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext>, Ordered {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {

    }

    @Override
    public int getOrder() {
        return 0;
    }
}

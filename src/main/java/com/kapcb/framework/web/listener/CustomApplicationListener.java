package com.kapcb.framework.web.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

/**
 * <a>Title: CustomApplicationListener </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CustomApplicationListener <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/18 22:35
 */
@Slf4j
@Component
public class CustomApplicationListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent applicationStartedEvent) {
        ConfigurableEnvironment environment = applicationStartedEvent.getApplicationContext().getEnvironment();
    }
}

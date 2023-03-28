package com.kapcb.context.runner;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;

/**
 * <a>Title: BaseApplicationShutDownHook </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BaseApplicationShutDownHook <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/28 21:01
 * @since 1.0
 */
public abstract class BaseApplicationShutDownHook {

    /**
     * application context close event
     *
     * @param applicationEvent {@link ApplicationEvent}
     */
    @EventListener(classes = {ContextClosedEvent.class})
    public abstract void applicationShutDownHook(ApplicationEvent applicationEvent);

}

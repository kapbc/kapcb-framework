package kapcb.framework.web.runner;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;

/**
 * <a>Title: BaseApplicationShutDownHook </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BaseApplicationShutDownHook <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/6 18:01
 */
public abstract class BaseApplicationShutDownHook {

    @EventListener(classes = {ContextClosedEvent.class})
    public abstract void applicationShutDownHook(ApplicationEvent applicationEvent);

}

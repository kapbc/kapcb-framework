package kapcb.framework.web.runner;

import kapcb.framework.web.util.KapcbUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * <a>Title: BaseApplicationShutDownHook </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BaseApplicationShutDownHook <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/6 18:01
 */
@Component
public class BaseApplicationShutDownHook {

    @EventListener(classes = {ContextClosedEvent.class})
    public void applicationShutDownHook(@NonNull ApplicationEvent applicationEvent) {
        KapcbUtil.serverShutDownHookBanner();
    }
}

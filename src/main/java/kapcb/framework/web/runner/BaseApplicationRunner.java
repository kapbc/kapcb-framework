package kapcb.framework.web.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

/**
 * <a>Title: BaseApplicationRunner </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/4 0:12
 */
public abstract class BaseApplicationRunner implements ApplicationRunner {

    public abstract Environment initEnvironment();
    public abstract ConfigurableApplicationContext initApplicationContext();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (initApplicationContext().isActive()) {
//            KapcbUtil.serverStartUpBanner(initEnvironment());
        }
    }
}

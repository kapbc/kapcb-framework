package kapcb.framework.web.runner;

import com.kapcb.framework.common.util.KapcbUtil;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class BaseApplicationRunner implements ApplicationRunner {

    public final Environment initEnvironment;
    public final ConfigurableApplicationContext initApplicationContext;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (initApplicationContext.isActive()) {
            KapcbUtil.serverStartUpBanner(initEnvironment);
        }
    }
}

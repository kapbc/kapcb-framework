package kapcb.framework.web.util;

import kapcb.framework.web.constants.enums.StringPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;

import java.time.LocalDateTime;

/**
 * <a>Title: KapcbUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 13:56
 */
@Slf4j
public class KapcbUtil {

    private KapcbUtil() {
    }

    public static void serverStartUpBanner(Environment environment) {
        String banner = "----------------------------------------------------------------------------------\n" +
                "server start success, current time is : " + LocalDateTime.now() + "\n" +
                "server name : " + environment.getProperty(StringPool.SERVER_APPLICATION_NAME.value()) + "\n" +
                "server port : " + environment.getProperty(StringPool.SERVER_PORT.value()) + "\n" +
                "----------------------------------------------------------------------------------";
        log.info(banner);
    }
}

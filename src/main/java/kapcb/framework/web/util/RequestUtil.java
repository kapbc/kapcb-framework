package kapcb.framework.web.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;

import javax.servlet.http.HttpServletRequest;

/**
 * <a>Title: RequestUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/11 0:16
 */
@Slf4j
public class RequestUtil {

    private RequestUtil() {
    }

    @NonNull
    public static boolean ajaxRequest(HttpServletRequest request) {
        log.info("the request head is {}", request.getHeader("X-Requested-With"));
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }
}
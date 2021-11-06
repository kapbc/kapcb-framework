package kapcb.framework.web.util;

import kapcb.framework.web.constants.enums.StringPool;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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
@UtilityClass
public class RequestUtil {

    @NonNull
    public static boolean ajaxRequest(HttpServletRequest request) {
        String xRequest = request.getHeader(StringPool.REQUEST_HEAD_X_REQUESTED_WITH.value());
        log.info("the request head is {}", xRequest);
        return StringPool.REQUEST_XML_HTTP_REQUEST.value().equals(xRequest);
    }

    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
     * 如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个, 而是一串IP值, 这种情况要获取ip, 只需要取X-Forwarded-For中第一个非unknown的有效IP字符串
     * 如：X-Forwarded-For: 192.168.1.110, 192.168.1.120, 192.168.1.130,
     * 192.168.1.110就是ip地址
     *
     * @param request HttpServletRequest
     * @return String
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader(StringPool.HTTP_REQUEST_X_FOR_WARDED_FOR.value());
        if (StringUtils.isBlank(ip) || StringUtils.equalsAnyIgnoreCase(StringPool.HTTP_REQUEST_UN_KNOWN.value(), ip)) {
            ip = request.getHeader(StringPool.HTTP_REQUEST_PROXY_CLIENT_IP.value());
        }
        if (StringUtils.isBlank(ip) || StringUtils.equalsAnyIgnoreCase(StringPool.HTTP_REQUEST_UN_KNOWN.value(), ip)) {
            ip = request.getHeader(StringPool.HTTP_REQUEST_WL_PROXY_CLIENT_IP.value());
        }
        if (StringUtils.isBlank(ip) || StringUtils.equalsAnyIgnoreCase(StringPool.HTTP_REQUEST_UN_KNOWN.value(), ip)) {
            ip = request.getHeader(StringPool.HTTP_REQUEST_HTTP_CLIENT_IP.value());
        }
        if (StringUtils.isBlank(ip) || StringUtils.equalsAnyIgnoreCase(StringPool.HTTP_REQUEST_UN_KNOWN.value(), ip)) {
            ip = request.getHeader(StringPool.HTTP_REQUEST_HTTP_X_FORWARDED_FOR.value());
        }
        if (StringUtils.isBlank(ip) || StringUtils.equalsAnyIgnoreCase(StringPool.HTTP_REQUEST_UN_KNOWN.value(), ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
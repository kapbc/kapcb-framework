package kapcb.framework.web.util;

import kapcb.framework.web.constants.enums.Image;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.servlet.http.HttpServletResponse;

/**
 * <a>Title: ResponseUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/11 0:16
 */
@Slf4j
public class ResponseUtil {

    private ResponseUtil() {
    }

    @NonNull
    public static void setHeader(@NonNull HttpServletResponse httpServletResponse, @Nullable String type) {
        // default png
        httpServletResponse.setContentType(MediaType.IMAGE_PNG_VALUE);
        if (StringUtils.equalsAnyIgnoreCase(type, Image.Type.GIF.type())) {
            httpServletResponse.setContentType(MediaType.IMAGE_GIF_VALUE);
        }
        httpServletResponse.setHeader(HttpHeaders.PRAGMA, "No-cache");
        httpServletResponse.setHeader(HttpHeaders.CACHE_CONTROL, "No-cache");
        httpServletResponse.setDateHeader(HttpHeaders.EXPIRES, 0L);
    }
}

package kapcb.framework.web.util;

import com.alibaba.fastjson.JSONObject;
import kapcb.framework.web.constants.IResultCode;
import kapcb.framework.web.model.base.BaseResult;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

/**
 * <a>Title: ResultUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 13:57
 */
@Slf4j
@UtilityClass
public class ResultUtil {

    /**
     * check and get data for collect
     *
     * @param resultList List<T>
     * @param <T>        T
     * @return List<T>
     */
    @NonNull
    public static <T> List<T> checkAndReturn(@Nullable List<T> resultList) {
        return CollectionUtils.isNotEmpty(resultList) ? resultList : Collections.emptyList();
    }

    /**
     * 设置响应
     *
     * @param httpServletResponse HttpServletResponse
     * @param contentType         String
     * @param status              Integer
     * @param value               响应内容
     * @param <T>                 T
     * @return boolean
     */
    public static <T> boolean setUpResponse(HttpServletResponse httpServletResponse, String contentType, Integer status, T value) throws IOException {
        httpServletResponse.setContentType(contentType);
        httpServletResponse.setStatus(status);
        httpServletResponse.getOutputStream().write(JSONObject.toJSONString(value).getBytes(StandardCharsets.UTF_8));
        return true;
    }

    /**
     * 设置成功响应
     *
     * @param httpServletResponse HttpServletResponse
     * @param value               响应内容
     * @param <T>                 T
     * @return boolean
     * @throws IOException IOException
     */
    public static <T> boolean setUpSuccessResponse(HttpServletResponse httpServletResponse, T value) throws IOException {
        return setUpResponse(httpServletResponse, MediaType.APPLICATION_JSON_VALUE, HttpServletResponse.SC_OK, value);
    }

    /**
     * 设置失败响应
     *
     * @param httpServletResponse HttpServletResponse
     * @param value               响应内容
     * @param <T>                 T
     * @return boolean
     * @throws IOException IOException
     */
    public static <T> boolean setUpFailureResponse(HttpServletResponse httpServletResponse, T value) throws IOException {
        return setUpResponse(httpServletResponse, MediaType.APPLICATION_JSON_VALUE, HttpServletResponse.SC_INTERNAL_SERVER_ERROR, value);
    }

//    public static <T> boolean setUpResponse(HttpServletResponse httpServletResponse, IResultCode resultCode){
//
//    }

}

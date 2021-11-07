//package kapcb.framework.web.model.base;
//
//import com.fasterxml.jackson.annotation.JsonFormat;
//import io.swagger.annotations.ApiModel;
//import kapcb.framework.web.constants.pattern.DatePatternPool;
//import lombok.Data;
//import lombok.experimental.Accessors;
//import org.springframework.lang.NonNull;
//
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
///**
// * <a>Title: BaseResult </a>
// * <a>Author: Kapcb <a>
// * <a>Description:  <a>
// *
// * @author Kapcb
// * @version 1.0.0
// * @date 2021/7/3 13:46
// */
//@Data
//@Accessors(chain = true)
//@ApiModel(value = "系统请求响应结果")
//public class BaseResult<T> implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    /**
//     * status code
//     */
//    private Integer code;
//
//    /**
//     * response message
//     */
//    private String msg;
//
//    /**
//     * data
//     */
//    private T data;
//
//    @JsonFormat(pattern = DatePatternPool.NORM_DATETIME_PATTERN)
//    private LocalDateTime time = LocalDateTime.now();
//
//    public BaseResult() {
//    }
//
//    public BaseResult(@NonNull ResultStatus resultStatus, T data) {
//        this.code = resultStatus.value();
//        this.msg = resultStatus.reasonPhrase();
//        this.data = data;
//    }
//
//    public BaseResult(@NonNull Integer code, @NonNull String msg, T data) {
//        this.code = code;
//        this.msg = msg;
//        this.data = data;
//    }
//
//    @NonNull
//    public static <T> BaseResult<T> success() {
//        return new BaseResult<>(ResultStatus.SUCCESS, null);
//    }
//
//    @NonNull
//    public static <T> BaseResult<T> success(T data) {
//        return new BaseResult<>(ResultStatus.SUCCESS, data);
//    }
//
//    @NonNull
//    public static <T> BaseResult<T> success(String message) {
//        return new BaseResult<>(ResultStatus.SUCCESS.value(), message, null);
//    }
//
//    @NonNull
//    public static <T> BaseResult<T> success(String message, T data) {
//        return new BaseResult<>(ResultStatus.SUCCESS.value(), message, data);
//    }
//
//    @NonNull
//    public static <T> BaseResult<T> fail() {
//        return new BaseResult<>(ResultStatus.FAIL, null);
//    }
//
//    @NonNull
//    public static <T> BaseResult<T> fail(T data) {
//        return new BaseResult<>(ResultStatus.FAIL, data);
//    }
//
//    @NonNull
//    public static <T> BaseResult<T> fail(String message) {
//        return new BaseResult<>(ResultStatus.FAIL.value(), message, null);
//    }
//
//    @NonNull
//    public static <T> BaseResult<T> fail(String message, T data) {
//        return new BaseResult<T>(ResultStatus.FAIL.value(), message, data);
//    }
//
//    public static <T> BaseResult<T> fail(ResultStatus resultStatus) {
//        return new BaseResult<>(resultStatus, null);
//    }
//
//    public static <T> BaseResult<T> fail(ResultStatus resultStatus, T data) {
//        return new BaseResult<>(resultStatus, data);
//    }
//
//    public static <T> BaseResult<T> fail(ResultStatus resultStatus, String message, T data) {
//        return new BaseResult<>(resultStatus.value(), message, data);
//    }
//
//    public static <T> BaseResult<T> fail(Throwable throwable) {
//        return new BaseResult<>(ResultStatus.FAIL.value(), throwable.getMessage(), null);
//    }
//
//    public static <T> BaseResult<T> fail(ResultStatus resultStatus, Throwable throwable) {
//        return new BaseResult<>(resultStatus.value(), throwable.getMessage(), null);
//    }
//
//    public static <T> BaseResult<T> fail(ResultStatus resultStatus, Throwable throwable, T data) {
//        return new BaseResult<>(resultStatus.value(), throwable.getMessage(), data);
//    }
//}
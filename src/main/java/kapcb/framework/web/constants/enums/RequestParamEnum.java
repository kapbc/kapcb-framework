package kapcb.framework.web.constants.enums;

/**
 * <a>Title: RequestParam </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 * 请求参数常量
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/11 15:59
 */
public enum RequestParamEnum {

    /**
     * 验证码 key
     */
    VERIFICATION_CODE_KEY("key", "request verification code key"),

    /**
     * 验证码 code
     */
    VERIFICATION_CODE_CODE("code", "request verification code"),

    /**
     * 认证授予的类型 key
     */
    AUTHENTICATION_GRANT_TYPE("", "authentication grant type"),

    /**
     * 用户登陆类型
     */
    LOGIN_TYPE("login_type", "user login type");

    private String value;
    private String description;

    RequestParamEnum(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String value() {
        return this.value;
    }
}

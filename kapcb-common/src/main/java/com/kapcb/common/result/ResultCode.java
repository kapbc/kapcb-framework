package com.kapcb.common.result;

/**
 * <a>Title: ResultCode </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ResultCode <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/19 10:23
 * @since 1.0
 */
public enum ResultCode implements IResultCode {

    SUCCESS("success", 200, "成功"),

    FAILED("fail", 501, "失败"),

    VALIDATE_PARAM_FAIL("parameter verification failed", 201, "请求参数校验失败"),

    UNAUTHORIZED("unauthorized", 402, "未经授权"),

    FORBIDDEN("no resource permission", 403, "禁止访问"),

    AUTHENTICATION_FAIL("username or password error", 405, "用户名或密码错误"),

    VALIDATE_CODE_ERROR("validate code error", 406, "登录验证码错误"),

    VALIDATE_CODE_EXPIRED("validate code expired", 407, "验证码已过期"),

    LOGIN_STATUS_EXPIRED("login status expired", 408, "登录状态已过期"),

    CAN_NOT_FOUND_LOGIN_INFO("can not found login info", 409, "登录信息不存在"),

    ;

    private String msg;

    private int code;

    private String description;

    ResultCode(String msg, int code, String description) {
        this.msg = msg;
        this.code = code;
        this.description = description;
    }

    @Override
    public String msg() {
        return null;
    }

    @Override
    public int code() {
        return 0;
    }
}

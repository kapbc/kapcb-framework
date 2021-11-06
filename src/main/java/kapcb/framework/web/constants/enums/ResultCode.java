package kapcb.framework.web.constants.enums;

import kapcb.framework.web.constants.IResultCode;

/**
 * <a>Title: ResultCode </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ResultCode <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/6 17:20
 */
public enum ResultCode implements IResultCode {

    SUCCESS(200, "success", "request process success"),
    FAILED(501, "fail", "request process fail"),
    VALIDATE_PARAM_FAIL(401, "request param error", "request param error"),
    UNAUTHORIZED(402, "please login", "un login or token expired"),
    FORBIDDEN(403, "no resource permission", "no resource access permission"),
    LOGIN_FAIL(405, "username or password error", "login username or password error");

    private String msg;

    private int code;

    private String description;

    ResultCode(int code, String msg, String description) {
        this.msg = msg;
        this.code = code;
        this.description = description;
    }

    @Override
    public String msg() {
        return this.msg;
    }

    @Override
    public int code() {
        return this.code;
    }
}

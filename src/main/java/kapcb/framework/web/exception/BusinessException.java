package kapcb.framework.web.exception;

import kapcb.framework.web.constants.IResultCode;

/**
 * <a>Title: BusinessException </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Business Exception <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 13:43
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private IResultCode resultCode;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(IResultCode resultCode) {
        super(resultCode.msg());
        this.resultCode = resultCode;
    }

    public BusinessException(Throwable throwable) {
        super(throwable);
    }

    public BusinessException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public IResultCode getResultCode() {
        return this.resultCode;
    }
}

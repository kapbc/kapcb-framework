package kapcb.framework.web.exception;

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

    public BusinessException(String message) {
        super(message);
    }

    private int code;

    public int getCode() {
        return this.code;
    }
}

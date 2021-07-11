package kapcb.framework.web.exception;

/**
 * <a>Title: VerificationCodeException </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/11 16:32
 */
public class VerificationCodeException extends RuntimeException{

    private static final long serialVersionUID = 7514854456967620043L;

    public VerificationCodeException(String message) {
        super(message);
    }
}

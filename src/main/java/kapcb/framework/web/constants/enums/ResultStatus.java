package kapcb.framework.web.constants.enums;

/**
 * <a>Title: ResultStatus </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 13:40
 */
public enum ResultStatus {

    SUCCESS(200, "success"),
    FAIL(-1,"fail"),
    PARAMETER_VALIDATION_FAIL(1005,"params validation fail");

    private final Integer value;
    private final String reasonPhrase;

    ResultStatus(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public Integer value() {
        return this.value;
    }

    public String reasonPhrase() {
        return this.reasonPhrase;
    }
}

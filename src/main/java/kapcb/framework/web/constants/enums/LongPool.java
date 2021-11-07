package kapcb.framework.web.constants.enums;

import kapcb.framework.web.constants.IEnumPool;

/**
 * <a>Title: LongPool </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 13:40
 */
public enum LongPool implements IEnumPool<Long> {

    ZERO(0L, "number 0"),
    ONE(1L, "number 1"),
    FIVE(5L, "number 5"),
    TEN(10L, "number 10");

    private Long value;
    private String description;

    LongPool(Long value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public Long value() {
        return this.value;
    }
}

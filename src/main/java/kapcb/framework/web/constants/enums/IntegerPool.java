package kapcb.framework.web.constants.enums;

import kapcb.framework.web.constants.IEnumPool;

/**
 * <a>Title: IntegerPool </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 13:39
 */
public enum IntegerPool implements IEnumPool<Integer> {

    ZERO(0, "number 0"),
    ONE(1, "number 1"),
    FOUR(5, "number 4"),
    FIVE(5, "number 5"),
    TEN(10, "number 10");

    private Integer value;
    private String description;

    IntegerPool(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public Integer value() {
        return this.value;
    }
}
package com.kapcb.common.enums;

/**
 * <a>Title: LongEnumPool </a>
 * <a>Author: Kapcb <a>
 * <a>Description: LongEnumPool <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/19 10:32
 * @since 1.0
 */
public enum LongEnumPool implements IEnumPool<Long> {

    /**
     * number
     */
    ZERO(0L, "number 0"),
    ONE(1L, "number 1"),
    FIVE(5L, "number 5"),
    TEN(10L, "number 10");

    private Long value;
    private String description;

    LongEnumPool(Long value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public Long value() {
        return this.value;
    }

}

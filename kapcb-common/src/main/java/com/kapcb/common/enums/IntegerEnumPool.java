package com.kapcb.common.enums;

/**
 * <a>Title: IntegerEnumPool </a>
 * <a>Author: Kapcb <a>
 * <a>Description: IntegerEnumPool <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/19 10:36
 * @since 1.0
 */
public enum IntegerEnumPool implements IEnumPool<Integer> {

    /**
     * number 0
     */
    ZERO(0, "number 0"),
    ONE(1, "number 1"),
    MINUS_ONE(-1, "负1"),
    FOUR(4, "number 4"),
    FIVE(5, "number 5"),
    TEN(10, "number 10"),
    THIRTY(30, "number 30"),
    TWO_HUNDRED_FIFTY_SIX(256, "number 256"),

    /**
     * rgb
     */
    RGB_0xFF0(0xFF000000, "rgb oxff00000"),
    RGB_0xFFF(0xFFFFFFFF, "rgb oxfffffff");

    private Integer value;

    private String description;

    IntegerEnumPool(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public Integer value() {
        return this.value();
    }

}

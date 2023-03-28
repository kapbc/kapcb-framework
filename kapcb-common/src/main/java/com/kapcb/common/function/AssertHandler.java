package com.kapcb.common.function;

/**
 * <a>Title: AssertHandler </a>
 * <a>Author: Kapcb <a>
 * <a>Description: AssertHandler <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/19 14:07
 * @since 1.0
 */
@FunctionalInterface
public interface AssertHandler {

    /**
     * 抛出异常信息
     *
     * @param message 异常信息
     */
    void assertion(String message);

}

package com.kapcb.common.function;

/**
 * <a>Title: BranchHandler </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BranchHandler <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/19 14:11
 * @since 1.0
 */
@FunctionalInterface
public interface BranchHandler extends Branch {

    /**
     * assert branch handler
     *
     * @param trueHandler  {@link Runnable}
     * @param falseHandler {@link Runnable}
     */
    void assertHandler(Runnable trueHandler, Runnable falseHandler);

}

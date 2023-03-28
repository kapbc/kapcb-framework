package com.kapcb.common.function;

import java.util.concurrent.Callable;

/**
 * <a>Title: BranchHandlerSupply </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BranchHandlerSupply <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/19 14:13
 * @since 1.0
 */
@FunctionalInterface
public interface BranchHandlerSupply<V> extends Branch {

    /**
     * supplier assert handler
     *
     * @param trueHandler  {@link Callable}
     * @param falseHandler {@link Callable}
     * @return V
     */
    V assertHandlerSupply(Callable<V> trueHandler, Callable<V> falseHandler);

}

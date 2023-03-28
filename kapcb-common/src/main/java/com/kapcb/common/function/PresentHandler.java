package com.kapcb.common.function;

import java.util.function.Consumer;

/**
 * <a>Title: PresentHandler </a>
 * <a>Author: Kapcb <a>
 * <a>Description: PresentHandler <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/19 14:15
 * @since 1.0
 */
@FunctionalInterface
public interface PresentHandler<T> {

    /**
     * do present
     *
     * @param consumer {@link Consumer}
     * @param runnable {@link Runnable}
     */
    void present(Consumer<? super T> consumer, Runnable runnable);

}

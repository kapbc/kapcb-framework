package com.kapcb.context.bean;

/**
 * <a>Title: BeanFactory </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BeanFactory <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/19 21:33
 * @since 1.0
 */
public interface BeanFactory {

    /**
     * get new instance by bean class type
     *
     * @param clazz Class<T>
     * @param <T>   <T>
     * @return T
     */
    <T> T newInstance(Class<T> clazz);

}

package com.kapcb.framework.web.bean;

/**
 * <a>Title: BeanFactory </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BeanFactory <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/7 14:12
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

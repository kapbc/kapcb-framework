package com.kapcb.context.core;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.Environment;

import java.util.Objects;

/**
 * <a>Title: ApplicationContextHolder </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ApplicationContextHolder <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/19 21:34
 * @since 1.0
 */
@Slf4j
public class ApplicationContextHolder implements ApplicationContextAware, DisposableBean {

    private static Environment environment;
    private static ApplicationContext applicationContext = null;

    @Override
    public void destroy() throws Exception {
        clearContextHolder();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ApplicationContextHolder.applicationContext == null) {
            log.warn("ApplicationContextHolder's applicationContext will be replace, original applicationContext is : {}", ApplicationContextHolder.applicationContext);
            ApplicationContextHolder.applicationContext = applicationContext;
            ApplicationContextHolder.environment = applicationContext.getEnvironment();
        }
    }

    @SuppressWarnings("unchecked")
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }

    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    public static boolean isSingleton(String name) {
        return applicationContext.isSingleton(name);
    }

    public static Class<? extends Object> getType(String name) {
        return applicationContext.getType(name);
    }

    public static Environment getEnvironment() {
        return environment;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void clear() {
        clearContextHolder();
    }

    private static void clearContextHolder() {
        log.info("begin to clear application context holder");
        applicationContext = null;
    }

    private static void assertContextInjected() {
        if (Objects.isNull(applicationContext)) {
            throw new IllegalStateException("please injected application context first");
        }
    }

}

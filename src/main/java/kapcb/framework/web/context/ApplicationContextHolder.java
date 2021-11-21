package kapcb.framework.web.context;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Objects;

/**
 * <a>Title: ApplicationContextHolder </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ApplicationContextHolder <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/19 22:45
 */
@Slf4j
public class ApplicationContextHolder implements ApplicationContextAware, DisposableBean {

    private static ApplicationContext applicationContext = null;

    /**
     * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
     *
     * @param name
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        assertContextInjected();
        return (T) applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        assertContextInjected();
        return (T) applicationContext.getBean(clazz);
    }

    public static void clearContextHolder() {
        log.info("begin to clear application context holder");
        applicationContext = null;
    }

    /**
     * 检查ApplicationContext
     */
    private static void assertContextInjected() {
        if (Objects.isNull(applicationContext)) {
            throw new IllegalStateException("please injected application context first");
        }
    }

    @Override
    public void destroy() throws Exception {
        ApplicationContextHolder.clearContextHolder();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (Objects.nonNull(ApplicationContextHolder.applicationContext)) {
            log.warn("ApplicationContextHolder's applicationContext will be replace, original applicationContext is : {}", ApplicationContextHolder.applicationContext);
        }
        ApplicationContextHolder.applicationContext = applicationContext;
    }
}

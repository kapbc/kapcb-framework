package kapcb.framework.web.aspect;

import kapcb.framework.web.constants.enums.StringPool;
import kapcb.framework.web.constants.pattern.DatePatternPool;
import kapcb.framework.web.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.env.Environment;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

/**
 * <a>Title: EndPointLogAspect </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 13:36
 */
@Slf4j
@Aspect
public abstract class WebLogAspect {

    public abstract Environment getEnvironment();
    public abstract HttpServletRequest getRequest();

    @Around("(@within(org.springframework.stereotype.Controller)) || @within(org.springframework.web.bind.annotation.RestController) && execution(public * com.kapcb.ccc..*.controller..*.*(..))")
    public Object controllerEndPointAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String className = proceedingJoinPoint.getTarget().getClass().getName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        LocalDateTime now = LocalDateTime.now();
        long startTime = System.currentTimeMillis();
        Object returnValue = null;
        Exception exception;
        try {
            returnValue = proceedingJoinPoint.proceed();
            return returnValue;
        } catch (Exception e) {
            exception = e;
            throw e;
        } finally {
            long costTime = System.currentTimeMillis() - startTime;
            log.info(StringPool.SPILT_LINE.value());
            log.info(StringPool.PROCESS_COST_TIME.value(), costTime);
            log.info(StringPool.PROCESS_CLASS_NAME.value(), className);
            log.info(StringPool.PROCESS_METHOD_NAME.value(), methodName);
            log.info(StringPool.PROCESS_LOCAL_DATE_TIME.value(), DateUtil.format(now, DatePatternPool.NORM_DATETIME_PATTERN));
            log.info(StringPool.SPILT_LINE.value());
        }
    }
}

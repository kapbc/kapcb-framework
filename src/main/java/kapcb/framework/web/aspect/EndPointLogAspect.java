package kapcb.framework.web.aspect;

import kapcb.framework.web.constants.pattern.DatePatternPool;
import kapcb.framework.web.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

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
public class EndPointLogAspect {

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
            log.info("----------------------------------------------------------------------");
            log.info("--------------process cost time : {}-------------", costTime);
            log.info("--------------process class name : {}-------------", className);
            log.info("--------------process method name : {}-------------", methodName);
            log.info("--------------current local date time : {}-------------", DateUtil.format(now, DatePatternPool.NORM_DATETIME_PATTERN));
            log.info("----------------------------------------------------------------------");
        }
    }
}

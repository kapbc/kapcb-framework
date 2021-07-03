package kapcb.framework.web.handler;

import kapcb.framework.web.constants.enums.ResultStatus;
import kapcb.framework.web.constants.enums.StringPool;
import kapcb.framework.web.exception.BusinessException;
import kapcb.framework.web.model.base.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.message.AuthException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Set;

/**
 * <a>Title: BaseGlobalExceptionHandler </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/4 0:13
 */
@Slf4j
@RestControllerAdvice
public class BaseGlobalExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public BaseResult handlerException(Exception e) {
        log.error("handlerException : " + e.getMessage(), e);
        return BaseResult.fail(e.getMessage());
    }

    @ExceptionHandler(value = {BusinessException.class})
    public BaseResult handlerSystemException(BusinessException e) {
        log.error("handler BusinessException : ", e);
        return BaseResult.fail(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @ExceptionHandler(value = {BusinessException.class})
    public BaseResult handlerBusinessException(BusinessException e) {
        return BaseResult.fail(e.getMessage(), e.getCode());
    }

    @ExceptionHandler(value = {BindException.class})
    public BaseResult handlerBindException(BindException e) {
        StringBuilder message = new StringBuilder();
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        for (FieldError error : fieldErrors) {
            message.append(error.getField()).append(error.getDefaultMessage()).append(" ,");
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        log.error("handler BindException : " + message.toString());
        return BaseResult.fail(message.toString(), ResultStatus.PARAMETER_VALIDATION_FAIL.value());
    }

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public BaseResult handlerConstraintViolationException(ConstraintViolationException e) {
        StringBuilder message = new StringBuilder();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        for (ConstraintViolation<?> violation : violations) {
            Path path = violation.getPropertyPath();
            String[] pathArray = StringUtils.splitByWholeSeparatorPreserveAllTokens(path.toString(), ".");
            message.append(pathArray[1]).append(violation.getMessage()).append((" ,"));
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        log.error("handler ConstraintViolationException : " + message.toString());
        return BaseResult.fail(message.toString(), ResultStatus.PARAMETER_VALIDATION_FAIL.value());
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public BaseResult handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        StringBuilder message = new StringBuilder();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            message.append(error.getField()).append(error.getDefaultMessage()).append(StringPool.SPACE_COMMA.value());
        }
        message = new StringBuilder(message.substring(0, message.length() - 1));
        log.error("handler MethodArgumentNotValidException : " + message.toString());
        return BaseResult.fail(message.toString(), ResultStatus.PARAMETER_VALIDATION_FAIL.value());
    }

    @ExceptionHandler(value = {AccessDeniedException.class})
    public BaseResult handlerAccessDeniedException(AccessDeniedException e) {
        log.error("handler AccessDeniedException : " + e.getMessage());
        return BaseResult.fail("No access Permission", HttpStatus.FORBIDDEN.value());
    }

    @ExceptionHandler(value = {HttpMediaTypeNotSupportedException.class})
    public BaseResult handlerHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        StringBuilder message = new StringBuilder();
        message.append("target method not support [").append(StringUtils.substringBetween(e.getMessage(), StringPool.SINGLE_QUOTES.value(), StringPool.SINGLE_QUOTES.value())).append("] ").append("media type");
        log.error("handler HttpMediaTypeNotSupportedException : " + message.toString());
        return BaseResult.fail(message.toString(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @ExceptionHandler(value = {HttpMediaTypeNotAcceptableException.class})
    public BaseResult handlerHttpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException e) {
        StringBuilder message = new StringBuilder();
        message.append("target method not accept [").append(StringUtils.substringBetween(e.getMessage(), StringPool.SINGLE_QUOTES.value(), StringPool.SINGLE_QUOTES.value())).append("] ").append(" method request");
        log.error("handler HttpMediaTypeNotAcceptableException : " + message.toString());
        return BaseResult.fail(message.toString(), HttpStatus.INTERNAL_SERVER_ERROR.value());
    }

    @ExceptionHandler(value = {AuthException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public BaseResult handlerAuthException(AuthException e) {
        log.error("handler AuthException : " + e.getMessage());
        return BaseResult.fail(e.getMessage(), HttpStatus.UNAUTHORIZED.value());
    }
}
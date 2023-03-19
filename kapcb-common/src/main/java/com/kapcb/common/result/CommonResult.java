package com.kapcb.common.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <a>Title: CommonResult </a>
 * <a>Author: Kapcb <a>
 * <a>Description: CommonResult <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/19 10:11
 * @since 1.0
 */
@Getter
@Setter
@ToString
public class CommonResult<T> implements Serializable {

    private static final long serialVersionUID = 5910869893509388367L;

    /**
     * 响应结果消息
     */
    private String msg;

    /**
     * 接口 uri
     */
    private String uri;

    /**
     * 状态码
     */
    private int code;

    /**
     * 时间戳
     */
    private long timestamp;

    /**
     * 接口响应结果
     */
    private T data;

    /**
     * 提供无参构造器
     */
    public CommonResult() {
    }

    /**
     * 提供有参构造器
     *
     * @param msg  {@linkplain CommonResult#msg}
     * @param code {@linkplain CommonResult#code}
     */
    public CommonResult(String msg, int code) {
        this.msg = msg;
        this.uri = null;
        this.code = code;
        this.timestamp = System.currentTimeMillis();
        this.data = null;
    }

    /**
     * 提供有参构造器
     *
     * @param msg  {@linkplain CommonResult#msg}
     * @param code {@linkplain CommonResult#code}
     * @param data {@linkplain CommonResult#data}
     */
    public CommonResult(String msg, int code, T data) {
        this.msg = msg;
        this.uri = null;
        this.code = code;
        this.timestamp = System.currentTimeMillis();
        this.data = data;
    }

    /**
     * 提供有参构造器
     *
     * @param msg  {@linkplain CommonResult#msg}
     * @param uri  {@linkplain CommonResult#uri}
     * @param code {@linkplain CommonResult#code}
     * @param data {@linkplain CommonResult#data}
     */
    public CommonResult(String msg, String uri, int code, T data) {
        this.msg = msg;
        this.uri = uri;
        this.code = code;
        this.timestamp = System.currentTimeMillis();
        this.data = data;
    }

    /**
     * 提供有参构造器
     *
     * @param msg       {@linkplain CommonResult#msg}
     * @param uri       {@linkplain CommonResult#uri}
     * @param code      {@linkplain CommonResult#code}
     * @param timestamp {@linkplain CommonResult#timestamp}
     * @param data      {@linkplain CommonResult#data}
     */
    public CommonResult(String msg, String uri, int code, long timestamp, T data) {
        this.msg = msg;
        this.uri = uri;
        this.code = code;
        this.timestamp = timestamp;
        this.data = data;
    }

    /**
     * 提供有参构造器
     *
     * @param resultCode {@link ResultCode}
     */
    public CommonResult(ResultCode resultCode) {
        this.msg = resultCode.msg();
        this.uri = null;
        this.code = resultCode.code();
        this.timestamp = System.currentTimeMillis();
        this.data = null;
    }

    /**
     * 提供有参构造器
     *
     * @param resultCode {@link ResultCode}
     * @param data       result data
     */
    public CommonResult(ResultCode resultCode, T data) {
        this.msg = resultCode.msg();
        this.uri = null;
        this.code = resultCode.code();
        this.timestamp = System.currentTimeMillis();
        this.data = data;
    }

    /**
     * 提供有参构造器
     *
     * @param resultCode {@link ResultCode}
     * @param data       result data
     * @param uri        request uri
     */
    public CommonResult(ResultCode resultCode, T data, String uri) {
        this.msg = resultCode.msg();
        this.uri = uri;
        this.code = resultCode.code();
        this.timestamp = System.currentTimeMillis();
        this.data = data;
    }

    /**
     * result success
     *
     * @return {@link CommonResult}
     */
    public static <T> CommonResult<T> success() {
        return new CommonResult<>(ResultCode.SUCCESS);
    }

    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(ResultCode.SUCCESS, data);
    }

    public static <T> CommonResult<T> success(T data, String uri) {
        return new CommonResult<>(ResultCode.SUCCESS, data, uri);
    }

    public static <T> CommonResult<T> success(ResultCode resultCode) {
        return new CommonResult<>(resultCode);
    }

    public static <T> CommonResult<T> success(ResultCode resultCode, T data) {
        return new CommonResult<>(resultCode, data);
    }

    public static <T> CommonResult<T> success(IResultCode iresultCode) {
        return new CommonResult<>(iresultCode.msg(), iresultCode.code());
    }

    public static <T> CommonResult<T> success(IResultCode iresultCode, T data) {
        return new CommonResult<>(iresultCode.msg(), iresultCode.code(), data);
    }

    /**
     * result fail
     */
    public static <T> CommonResult<T> fail() {
        return new CommonResult<>(ResultCode.FAILED);
    }

    public static <T> CommonResult<T> fail(String msg) {
        return new CommonResult<>(msg, ResultCode.FAILED.code());
    }

    public static <T> CommonResult<T> fail(Throwable throwable) {
        return new CommonResult<>(throwable.getMessage(), ResultCode.FAILED.code());
    }

    public static <T> CommonResult<T> fail(String msg, int code) {
        return new CommonResult<>(msg, code);
    }

    public static <T> CommonResult<T> fail(ResultCode resultCode) {
        return new CommonResult<>(resultCode);
    }

    public static <T> CommonResult<T> fail(ResultCode resultCode, T data) {
        return new CommonResult<>(resultCode, data);
    }

    public static <T> CommonResult<T> fail(IResultCode iresultCode) {
        return new CommonResult<>(iresultCode.msg(), iresultCode.code());
    }

    public static <T> CommonResult<T> fail(IResultCode iresultCode, T data) {
        return new CommonResult<>(iresultCode.msg(), iresultCode.code(), data);
    }

    public static <T> CommonResult<T> fail(IResultCode iresultCode, Throwable throwable) {
        return new CommonResult<>(throwable.getMessage(), iresultCode.code());
    }

    public static <T> CommonResult<T> fail(IResultCode iresultCode, Throwable throwable, T data) {
        return new CommonResult<>(throwable.getMessage(), iresultCode.code(), data);
    }

    /**
     * validate param fail
     */
    public static <T> CommonResult<T> validateParamFail() {
        return new CommonResult<>(ResultCode.VALIDATE_PARAM_FAIL);
    }

    public static <T> CommonResult<T> validateParamFail(String msg) {
        return new CommonResult<>(msg, ResultCode.VALIDATE_PARAM_FAIL.code());
    }

    /**
     * unauthorized
     *
     * @return {@link CommonResult}
     */
    public static <T> CommonResult<T> unauthorized() {
        return new CommonResult<>(ResultCode.UNAUTHORIZED);
    }

    public static <T> CommonResult<T> unauthorized(T data) {
        return new CommonResult<>(ResultCode.UNAUTHORIZED, data);
    }

    public static <T> CommonResult<T> unauthorized(String msg) {
        return new CommonResult<>(msg, ResultCode.UNAUTHORIZED.code());
    }

    /**
     * forbidden
     *
     * @return {@link CommonResult}
     */
    public static <T> CommonResult<T> forbidden() {
        return new CommonResult<>(ResultCode.FORBIDDEN);
    }

    public static <T> CommonResult<T> forbidden(T data) {
        return new CommonResult<>(ResultCode.FORBIDDEN, data);
    }

    /**
     * authentication fail
     *
     * @return {@link CommonResult}
     */
    public static <T> CommonResult<T> authenticationFail() {
        return new CommonResult<>(ResultCode.AUTHENTICATION_FAIL);
    }

    public static <T> CommonResult<T> authenticationFail(T data) {
        return new CommonResult<T>(ResultCode.AUTHENTICATION_FAIL, data);
    }

    public static <T> CommonResult<T> authenticationFail(String msg) {
        return new CommonResult<T>(msg, ResultCode.AUTHENTICATION_FAIL.code());
    }

}

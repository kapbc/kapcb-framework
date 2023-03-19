package com.kapcb.common.enums;

/**
 * <a>Title: StringEnumPool </a>
 * <a>Author: Kapcb <a>
 * <a>Description: StringEnumPool <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/19 10:42
 * @since 1.0
 */
public enum StringEnumPool implements IEnumPool<String> {

    /**
     * Common Constants
     */
    SEMICOLON(";", "分号"),
    COLON(":", "冒号"),
    COMMA(",", "逗号"),
    SPACE(" ", "空格"),
    HYPHEN("-", "横杠"),
    SPACE_HYPHEN(" - ", "空格横杠"),
    UNDER_CROSS("_", "下划线"),
    SPACE_COMMA(" ,", "空格逗号"),
    EMPTY_STRING("", "空字符串"),
    SINGLE_QUOTES("'", "单引号"),
    SHARP("#", "#号"),
    STAR("*", "*号"),
    AT_SIGN("@", "@号"),
    PERCENT_SIGN("%", "%号"),
    DOLLAR_SIGN("$", "$号"),
    EXCLAMATION_SIGN("!", "!号"),
    SLASH("/", "斜杠"),
    DOT(".", "点"),
    EMPTY_OBJECT("{}", "空对象"),
    OPENING_PARENTHESIS("{", "开括号"),
    CLOSED_PARENTHESIS("}", "关括号"),
    EQUALS("=", "等哈"),
    AND("&", "and"),

    PK_NULL_VALUE("0", "主键为空的字符串值"),

    /**
     * SQL Programmer
     */
    SQL_ORDER("ORDER", "SQL排序"),
    SQL_ACS("ASC", "SQL正序"),
    SQL_DESC("DESC", "SQL倒序"),
    SQL_LIMIT("LIMIT", "SQL限定数量"),
    SQL_LIMIT_ONE("LIMIT 1", "SQL限定数量1"),

    /**
     * Image Suffix
     */
    IMAGE_SUFFIX_PNG("png", "image with png"),
    IMAGE_SUFFIX_JPG("jpg", "image with jpg"),
    IMAGE_SUFFIX_JPEG("jpeg", "image with jpeg"),
    IMAGE_SUFFIX_GIF("gif", "image with gif"),
    IMAGE_SUFFIX_ICO("ico", "image with ico"),


    REQUEST_RETURN_VALUE("request return value is : {}", "return value"),
    REQUEST_ERROR_MESSAGE("handler request error, error message is : {}", "error message"),
    REQUEST_SERVER_NAME("server name is : {}", "server name"),
    REQUEST_URL("request url : {}", "request url"),
    REQUEST_URI("request uri : {}", "request uri"),
    PROCESS_COST_TIME("process cost time : {} ms", "process cost time"),
    PROCESS_CLASS_NAME("process class name : {}", "process class name"),
    PROCESS_METHOD_NAME("process method name : {}", "process method name"),
    PROCESS_LOCAL_DATE_TIME("current local date time : {}", "current local date time"),
    SPILT_LINE("[----------------------------------------------------------------------]", "spilt line"),

    /**
     * Http Servlet Request
     */
    HTTP_REQUEST_USER_AGENT("User-Agent", "用户浏览器"),
    HTTP_REQUEST_UN_KNOWN("unknown", "未知"),
    HTTP_REQUEST_X_FOR_WARDED_FOR("x-forwarded-for", "获取ip地址请求中的key"),
    HTTP_REQUEST_PROXY_CLIENT_IP("Proxy-Client-IP", "获取ip地址请求中的key"),
    HTTP_REQUEST_WL_PROXY_CLIENT_IP("WL-Proxy-Client-IP", "获取ip地址请求中的key"),
    HTTP_REQUEST_HTTP_CLIENT_IP("HTTP_CLIENT_IP", "获取ip地址请求中的key"),
    HTTP_REQUEST_HTTP_X_FORWARDED_FOR("HTTP_X_FORWARDED_FOR", "获取ip地址请求中的key"),
    HTTP_REQUEST_AUTHORIZATION("Authorization", "http请求头中的Authorization"),
    AUTHORIZATION_BEARER("Bearer ", "Bearer "),

    REQUEST_HEAD_X_REQUESTED_WITH("X-Requested-With", "request head中获取ajax请求标识的key"),
    REQUEST_XML_HTTP_REQUEST("XMLHttpRequest", "request head中ajax请求的标识"),

    RESPONSE_HEAD_NO_CACHE("No-cache", "response head no cache"),

    CHINESE_MATCH_REGEX("[\\u4e00-\\u9fa5]", "chinese match regex"),

    DICTIONARY_REMARK_CAPITAL_CITY("capital", "capital city remark"),
    DICTIONARY_REMARK_NON_CAPITAL_CITY("default", "non capital city remark"),
    DICTIONARY_GROUP_COUNTRY("country", "dictionary country group"),
    DICTIONARY_GROUP_CITY("city", "dictionary city group"),
    DICTIONARY_GROUP_PROVINCE("province", "dictionary province group"),

    /**
     * Server Configuration Document Key
     */
    SERVER_APPLICATION_NAME("spring.application.name", "获取服务名称"),
    SERVER_PORT("server.port", "获取服务端口号"),
    MAIN("main", "main method"),

    AUTHENTICATION_VERIFICATION_CODE_KEY("key", "前端请求验证码key"),
    AUTHENTICATION_REDIS_STORE_KEY("arsk&&", "保存验证码的redis key"),

    CHARACTER_SET_UTF_8_UPPER("utf-8", "character set utf -8 upper case"),
    CHARACTER_SET_UTF_8_LOWER("UTF-8", "character set utf -8 lower case"),

    REQUEST_CITY_HTTP_URL("http://whois.pconline.com.cn/ipJson.jsp?ip={}&json=true", "get user city info api url"),

    CLASS("class", "class name"),
    METHOD_NAME("methodName", "method name"),
    PACKAGE("package", "class package"),

    BACK_SLASH_N("\n", "the back slash n");;

    private String value;
    private String description;

    StringEnumPool(String value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    public String value() {
        return this.value();
    }
}

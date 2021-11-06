package kapcb.framework.web.constants.enums;

import kapcb.framework.web.constants.IEnumPool;
import org.springframework.lang.NonNull;

/**
 * <a>Title: StringPool </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 13:39
 */
public enum StringPool implements IEnumPool<String> {

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

    PK_NULL_VALUE("0", "主键为空的字符串值"),

    /**
     * SQL Programmer
     */
    SQL_ORDER("ORDER", "SQL排序"),
    SQL_ACS("ASC", "SQL正序"),
    SQL_DESC("DESC", "SQL倒序"),
    SQL_LIMIT("LIMIT", "SQL限定数量"),

    /**
     * Image Suffix
     */
    IMAGE_SUFFIX_PNG("png", "image with png"),
    IMAGE_SUFFIX_JPG("jpg", "image with jpg"),
    IMAGE_SUFFIX_JPEG("jpeg", "image with jpeg"),
    IMAGE_SUFFIX_GIF("gif", "image with gif"),
    IMAGE_SUFFIX_ICO("ico", "image with ico"),

    REQUEST_URL("request url : {}", "request url"),
    REQUEST_URI("request uri : {}", "request uri"),
    PROCESS_COST_TIME("process cost time : {} ms", "process cost time"),
    PROCESS_CLASS_NAME("process class name : {}", "process class name"),
    PROCESS_METHOD_NAME("process method name : {}", "process method name"),
    PROCESS_LOCAL_DATE_TIME("current local date time : {}", "current local date time"),
    SPILT_LINE("[----------------------------------------------------------------------]", "spilt line"),

    /**
     * Server Configuration Document Key
     */
    SERVER_APPLICATION_NAME("spring.application.name", "获取服务名称"),

    SERVER_PORT("server.port", "获取服务端口号"),
    ;

    private String value;
    private String description;

    StringPool(String value, String description) {
        this.value = value;
        this.description = description;
    }

    @Override
    @NonNull
    public String value() {
        return this.value;
    }
}
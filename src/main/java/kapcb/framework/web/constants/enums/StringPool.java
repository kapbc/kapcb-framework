package kapcb.framework.web.constants.enums;

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
public enum StringPool {

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

    PK_NULL_VALUE("0", "主键为空的字符串值"),

    /**
     * SQL programmer
     */
    SQL_ORDER("ORDER", "SQL排序"),
    SQL_ACS("ASC", "SQL正序"),
    SQL_DESC("DESC", "SQL倒序"),
    SQL_LIMIT("LIMIT", "SQL限定数量"),


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

    @NonNull
    public String value() {
        return this.value;
    }
}
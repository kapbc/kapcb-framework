package kapcb.framework.web.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import kapcb.framework.web.constants.enums.IntegerPool;
import kapcb.framework.web.constants.enums.StringPool;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <a>Title: JsonUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 13:55
 */
@Slf4j
@UtilityClass
public class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
    }

    /**
     * convert value
     *
     * @param source Object
     * @param clazz  Class<? extends T>
     * @param <T>    <T>
     * @return T
     */
    public static <T> T convertValue(Object source, Class<? extends T> clazz) {
        if (Objects.isNull(source)) {
            return null;
        }
        return OBJECT_MAPPER.convertValue(source, clazz);
    }

    /**
     * convert object to json string
     *
     * @param object T
     * @param <T>    <T>
     * @return String
     */
    public static <T> String toJsonString(T object) {
        if (Objects.equals(null, object)) {
            return null;
        }
        String convertResult = null;
        try {
            return object instanceof String ? (String) object : OBJECT_MAPPER.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("json process error, the exception is : " + e.getMessage());
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T readValue(byte[] bytes, Class<? extends T> clazz) {
        try {
            return Objects.equals(String.class, clazz) ? (T) new String(bytes) : OBJECT_MAPPER.readValue(bytes, clazz);
        } catch (IOException e) {
            log.error("process json process error, the exception is : " + e.getMessage());
        }
        return (T) StringPool.EMPTY_OBJECT.value();
    }

    public static <T> String toJsonStringPretty(T object) {
        if (Objects.equals(null, object)) {
            return null;
        }
        String convertResult = null;
        try {
            return object instanceof String ? (String) object : OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("json process error, the exception is : " + e.getMessage());
            return null;
        }
    }

    /**
     * convert json string to object
     *
     * @param jsonString String
     * @param clazz      Class<T>
     * @param <T>        <T>
     * @return String
     */
    @SuppressWarnings("unchecked")
    public static <T> T readValue(String jsonString, Class<T> clazz) {
        if (StringUtils.isBlank(jsonString) || clazz == null) {
            return null;
        }
        T convertResult = null;
        try {
            return Objects.equals(clazz, String.class) ? (T) jsonString : OBJECT_MAPPER.readValue(jsonString, clazz);
        } catch (IOException e) {
            log.error("json process error, the exception is : " + e.getMessage());
            return null;
        }
    }

    /**
     * jsonString convert to collection object
     *
     * @param jsonString    String
     * @param typeReference TypeReference<T>
     * @param <T>           <T>
     * @return T
     */
    @SuppressWarnings("unchecked")
    public static <T> T readValue(String jsonString, TypeReference<T> typeReference) {
        if (StringUtils.isBlank(jsonString) || typeReference == null) {
            return null;
        }
        try {
            return Objects.equals(typeReference.getType(), String.class) ? (T) jsonString : OBJECT_MAPPER.readValue(jsonString, typeReference);
        } catch (IOException e) {
            log.error("json process error, the exception is : " + e.getMessage());
            return null;
        }
    }

    /**
     * jsonString convert to collection object
     *
     * @param jsonString      String
     * @param collectionClass Class<?>
     * @param elementClasses  Class<?>
     * @param <T>             <T>
     * @return T
     */
    @SuppressWarnings("unchecked")
    public static <T> T readValue(String jsonString, Class<?> collectionClass, Class<?>... elementClasses) {
        JavaType javaType = OBJECT_MAPPER.getTypeFactory().constructParametricType(collectionClass, elementClasses);
        try {
            return OBJECT_MAPPER.readValue(jsonString, javaType);
        } catch (IOException e) {
            log.error("json process error, the exception is : " + e.getMessage());
            return null;
        }
    }

    /**
     * Map builder
     */
    public static class JsonBuilder {

        private final Map<String, Object> builderMap = new HashMap<>(IntegerPool.FOUR.value());

        public JsonBuilder() {
        }

        public JsonUtil.JsonBuilder put(String key, Object value) {
            builderMap.put(key, value);
            return this;
        }

        public String builder() {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.writeValueAsString(this.builderMap);
            } catch (JsonProcessingException e) {
                log.error("json process error, the exception is : " + e.getMessage(), e);
            }
            return StringPool.EMPTY_OBJECT.value();
        }
    }
}
package kapcb.framework.web.util;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.Type;
import ma.glasnost.orika.metadata.TypeFactory;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

/**
 * <a>Title: OrikaUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 13:56
 */
@Slf4j
public class OrikaUtil {

    private static final MapperFacade MAPPER_FACADE;

    static {
        // 默认字段工厂
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().useAutoMapping(true).mapNulls(true).build();
        // 默认字段实例
        MAPPER_FACADE = mapperFactory.getMapperFacade();
    }

    /**
     * 映射实体
     *
     * @param data    数据
     * @param toClass 需要映射的类对象
     * @param <R>     映射类型
     * @param <T>     数据
     * @return R
     */
    @SneakyThrows(Exception.class)
    public static <R, T> R map(T data, Class<R> toClass) {
        return MAPPER_FACADE.map(data, toClass);
    }

//    public static <S, T> S map(T data, Class<S> toClass, Map<String, String> configMap) {
//    }

    @SneakyThrows(Exception.class)
    public static <R, T> List<R> mapList(@NonNull Collection<T> data, Class<R> toClass) {
        return MAPPER_FACADE.mapAsList(data, toClass);
    }

//    private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
//
//    private final String entitySuffix = "DO";
//
//    static {
//        mapperFactory.getConverterFactory().registerConverter(new UtilDateConverter());
//        mapperFactory.getConverterFactory().registerConverter(new BigDecimalConverter());
//    }
//
//    public <T,R> T convert(R source, Class<T> targetClass) {
//        if(mapperFactory.existsRegisteredMapper(TypeFactory.<R> valueOf(source.getClass()), TypeFactory.valueOf(targetClass), false)){
//            return mapperFactory.getMapperFacade().map(source, targetClass);
//        }
//        ClassMapBuilder<?, T> builder = mapperFactory.classMap(source.getClass(), targetClass);
//        if (source instanceof BaseDO) {
//            try {
//                builder = builder.field("id", StringUtils.firstCharToLower(source.getClass().getSimpleName().replaceAll(entitySuffix, "Id")));
//            } catch (MappingException e) {
//                // do nothing
//            }
//        }
//        if (BaseDO.class.equals(targetClass.getSuperclass())) {
//            try {
//                builder = builder.field(StringUtils.firstCharToLower(targetClass.getSimpleName().replaceAll(entitySuffix, "Id")), "id");
//            } catch (MappingException e) {
//                // do nothing
//            }
//        }
//        builder.byDefault().register();
//        return mapperFactory.getMapperFacade().map(source, targetClass);
//    }
//
//    private class UtilDateConverter extends BidirectionalConverter<Date, String> {
//        public static final FastDateFormat DEFAULT_FAST_DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
//
//        @Override
//        public String convertTo(Date source, Type<String> destinationType, MappingContext context) {
//            return DEFAULT_FAST_DATE_FORMAT.format(source);
//        }
//
//        @Override
//        public Date convertFrom(String source, Type<Date> destinationType, MappingContext context) {
//            try {
//                return DateUtils.parseDate(source, "yyyy-MM-dd HH:mm:ss");
//            } catch (final ParseException e) {
//                log.error("[OrikaUtil] Exception ", e);
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    private class BigDecimalConverter extends BidirectionalConverter<Bigdecimal, String> {
//
//        @Override
//        public String convertTo(BigDecimal source, Type<String> destinationType, MappingContext context) {
//            return source.toString();
//        }
//
//        @Override
//        public BigDecimal convertFrom(String source, Type<Bigdecimal> destinationType, MappingContext context) {
//            return new BigDecimal(source);
//        }
//    }
//}
    
}

package kapcb.framework.web.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

/**
 * <a>Title: MyBatisPlusProperties </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 14:46
 */
@ConditionalOnProperty(prefix = "")
public class MyBatisPlusProperties {

//    @Value(value = "mybatis.plus.database.type:mysql")
    private String sourceType;
}

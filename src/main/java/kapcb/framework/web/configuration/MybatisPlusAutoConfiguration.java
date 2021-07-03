package kapcb.framework.web.configuration;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

/**
 * <a>Title: MybatisPlusAutoConfiguration </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 14:45
 */
@Slf4j
//@ConditionalOnProperty(value = "", havingValue = "", matchIfMissing = true)
public class MybatisPlusAutoConfiguration {

    /**
     * 连接的数据库类型, 默认mysql
     */
    @Value(value = "mybatis.plus.database.type:mysql")
    private String datasourceType;

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        // 配置mybatis plus 分页插件
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        // 配置mybatis plus 乐观锁插件
        mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return mybatisPlusInterceptor;
    }

//    @Bean
////    @ConditionalOnMissingBean
//    public MybatisPlusSqlInjector mybatisPlusSqlInjector(){
//        // 自定义注入器 实现自定义方法注入
//        return new MybatisPlusSqlInjector();
//    }
}

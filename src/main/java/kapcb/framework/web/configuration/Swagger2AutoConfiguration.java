package kapcb.framework.web.configuration;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: swagger2AutoConfiguration </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 14:43
 */
@Slf4j
@EnableKnife4j
@EnableSwagger2
public class Swagger2AutoConfiguration {

    private static final String API_INFO_NAME = "kapcb";
    private static final String API_INFO_GROUP_NAME = "kapcb";
    private static final String API_INFO_URL = "https://www.kapcb.com/api";
    private static final String API_INFO_EMAIL = "eircccallroot@163.com";

    @Value("${kapcb.knife4j.basic.title:kapcb}")
    private String title;
    @Value("${kapcb.knife4j.basic.version:1.0.RELEASE}")
    private String version;
    @Value("${kapcb.knife4j.basic.desc:kapcb接口")
    private String desc;
    @Value("${kapcb.knife4j.basic.enable:false}")
    private Boolean enable;

    @Bean
    public Docket createApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .apiInfo(apiInfo())
                .groupName(API_INFO_GROUP_NAME)
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
    }

    private List<SecurityContext> securityContexts() {
        // 设置需要登录认证的路径
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("^(?!auth).*$")).build());
        return securityContexts;
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        List<SecurityReference> securityReferences = new ArrayList<>();
        securityReferences.add(new SecurityReference("Authorization", authorizationScopes));
        return securityReferences;
    }

    private List<SecurityScheme> securitySchemes() {
        // 设置请求头信息
        List<SecurityScheme> securitySchemes = new ArrayList<>();
        ApiKey token = new ApiKey("Authorization", "Authorization", "header");
        ApiKey language = new ApiKey("language", "language", "header");
        securitySchemes.add(token);
        securitySchemes.add(language);
        return securitySchemes;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .contact(new Contact(API_INFO_NAME, API_INFO_URL, API_INFO_EMAIL))
                .description(desc)
                .title(title)
                .version(version).build();
    }
}
package com.machine.dragon.starter.swagger.config;

import com.machine.dragon.common.launch.constant.DragonAppConstant;
import com.machine.dragon.common.launch.property.DragonPropertySource;
import com.machine.dragon.starter.swagger.propertity.DragonSwaggerProperties;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Arrays;
import java.util.List;

@Configuration
@AllArgsConstructor
@EnableSwagger2WebMvc
@EnableConfigurationProperties(DragonSwaggerProperties.class)
@DragonPropertySource(value = "classpath:/dragon-swagger.yml")
public class DragonSwaggerAutoConfiguration {
    private static final List<String> DEFAULT_EXCLUDE_PATH = Arrays.asList("/error", "/actuator/**");

    /**
     * 引入Blade环境变量
     */
    private final DragonSwaggerProperties dragonSwaggerProperties;

    @Bean
    public Docket createRestApi() {
        if (dragonSwaggerProperties.getExcludePath().size() == 0) {
            dragonSwaggerProperties.getExcludePath().addAll(DEFAULT_EXCLUDE_PATH);
        }
        ApiSelectorBuilder apis = new Docket(DocumentationType.SWAGGER_2)
                .host(dragonSwaggerProperties.getHost())
                .apiInfo(apiInfo(dragonSwaggerProperties)).select()
                .apis(RequestHandlerSelectors.basePackage(DragonAppConstant.BASE_PACKAGES));
        dragonSwaggerProperties.getExcludePath().forEach(p -> apis.paths(PathSelectors.ant(p).negate()));
        return apis.build();
    }

    /**
     * 配置基本信息
     */
    private ApiInfo apiInfo(DragonSwaggerProperties swaggerProperties) {
        return new ApiInfoBuilder()
                .title(swaggerProperties.getTitle())
                .description(swaggerProperties.getDescription())
                .license(swaggerProperties.getLicense())
                .licenseUrl(swaggerProperties.getLicenseUrl())
                .termsOfServiceUrl(swaggerProperties.getTermsOfServiceUrl())
                .contact(new Contact(swaggerProperties.getContact().getName(), swaggerProperties.getContact().getUrl(), swaggerProperties.getContact().getEmail()))
                .version(swaggerProperties.getVersion())
                .build();
    }
}
package com.machine.dragon.starter.swagger.config;

import com.machine.dragon.common.launch.constant.DragonAppConstant;
import com.machine.dragon.common.launch.property.DragonProperties;
import com.machine.dragon.common.launch.property.DragonPropertySource;
import com.machine.dragon.starter.swagger.propertity.DragonSwaggerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
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
@EnableSwagger2WebMvc
@EnableConfigurationProperties({DragonProperties.class, DragonSwaggerProperties.class})
@DragonPropertySource(value = "classpath:/dragon-swagger.yml")
@Profile(value = "!prod")
public class DragonSwaggerAutoConfiguration {

    @Autowired
    private DragonProperties dragonProperties;

    @Autowired
    private DragonSwaggerProperties swaggerProperties;

    @Bean
    public Docket createRestApi() {
        if (swaggerProperties.getExcludePath().size() == 0) {
            swaggerProperties.getExcludePath().addAll(DEFAULT_EXCLUDE_PATH);
        }
        ApiSelectorBuilder apis = new Docket(DocumentationType.SWAGGER_2)
                .host(swaggerProperties.getHost())
                .apiInfo(apiInfo(swaggerProperties))
                .groupName(dragonProperties.getName())
                .select()
                .apis(RequestHandlerSelectors.basePackage(DragonAppConstant.BASE_PACKAGES));
        swaggerProperties.getExcludePath().forEach(p -> apis.paths(PathSelectors.ant(p).negate()));
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

    private static final List<String> DEFAULT_EXCLUDE_PATH = Arrays.asList("/error", "/actuator/**");
}
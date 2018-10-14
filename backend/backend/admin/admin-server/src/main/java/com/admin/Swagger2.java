package com.admin;

import com.hengyunsoft.commons.adapter.Swagger2WebMvcConfigurerAdapter;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Swagger2的配置类
 *
 * @author xubin.
 * @create 2017-04-08
 */

@Configuration
@EnableSwagger2
@EnableConfigurationProperties({Swagger2.Swagger2Properties.class})
public class Swagger2 extends Swagger2WebMvcConfigurerAdapter {
    private final static String MODULAR_ADMIN = "admin";
    private final static String MODULAR_DEVELOPER = "developer";
    @Autowired
    Swagger2Properties swagger2Properties;

    /**
     * 权限服务对外 swagger文档
     *
     * @return
     */

    @Bean
    public Docket createAdminInsideApi() {

        List<Parameter> pars = getParameters();
        ArrayList<ResponseMessage> responseMessages = getResponseMessages();
        String basePackage = swagger2Properties.getAdminMap().get("impl-package");
        String basePath = swagger2Properties.getAdminMap().get("base-path");
        return getDocket(swagger2Properties.getAdminMap(),basePackage,"insid_admin",pars,responseMessages)
                .pathProvider(new RelativePathProvider(servletContext) {
                    @Override
                    public String getApplicationBasePath() {
                        return basePath + super.getApplicationBasePath();
                    }
                });
    }
    private ApiInfo apiInfo() {// 创建API的基本信息，这些信息会在Swagger UI中进行显示
        return new ApiInfoBuilder()
                .title("博客权限API")// API 标题
                .description("权限")// API描述
                .contact("wz@")// 联系人
                .version("1.0")// 版本号
                .build();
    }

    @Override
    protected Swagger2BaseProperties getSwagger2BaseProperties() {
        return swagger2Properties;
    }

    @ConfigurationProperties(
            prefix = "swagger2"
    )
    @Data
    static class Swagger2Properties extends Swagger2BaseProperties{
        private Map<String, String> adminMap = new LinkedHashMap<>();
//        private Map<String, String> developerMap = new LinkedHashMap<>();
    }
}

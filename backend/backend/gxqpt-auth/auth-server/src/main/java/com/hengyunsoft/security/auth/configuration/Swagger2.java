//package com.hengyunsoft.security.auth.configuration;
//
//import com.hengyunsoft.commons.adapter.Swagger2WebMvcConfigurerAdapter;
//import com.hengyunsoft.commons.context.CommonConstants;
//import lombok.Data;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.service.ResponseMessage;
//import springfox.documentation.spring.web.paths.RelativePathProvider;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///**
// * Swagger2的配置类
// *
// * @author xubin.
// * @create 2017-04-08
// */
//
//@Configuration
//@EnableSwagger2
//@EnableConfigurationProperties({Swagger2.Swagger2Properties.class})
//public class Swagger2 extends Swagger2WebMvcConfigurerAdapter {
//    private final static String MODULAR_AUTH = "auth";
//    @Autowired
//    Swagger2Properties swagger2Properties;
//
//    @Override
//    protected Swagger2WebMvcConfigurerAdapter.Swagger2BaseProperties getSwagger2BaseProperties() {
//        return swagger2Properties;
//    }
//
//    @Bean
//    public Docket createAuthInsideApi() {
//        //List<Parameter> pars = getParameters();
//        ArrayList<ResponseMessage> responseMessages = getResponseMessages();
//        String basePackage = swagger2Properties.getAuthMap().get("impl-package");
//        String basePath = swagger2Properties.getAuthMap().get("base-path");
//        return getDocket(swagger2Properties.getAuthMap(),
//                basePackage, CommonConstants.SWAGGER_GROUP_INSIDE + MODULAR_AUTH,
//                null, responseMessages).pathProvider(new RelativePathProvider(servletContext) {
//            @Override
//            public String getApplicationBasePath() {
//                return basePath + super.getApplicationBasePath();
//            }
//        });
//    }
//    @Bean
//    public Docket createAuthPubApi() {
//        //List<Parameter> pars = getParameters();
//        ArrayList<ResponseMessage> responseMessages = getResponseMessages();
//        String basePackage = swagger2Properties.getAuthMap().get("open-package");
//        String basePath = swagger2Properties.getAuthMap().get("base-path");
//        return getDocket(swagger2Properties.getAuthMap(),
//                basePackage, CommonConstants.SWAGGER_GROUP_PUB + MODULAR_AUTH,
//                null, responseMessages).pathProvider(new RelativePathProvider(servletContext) {
//            @Override
//            public String getApplicationBasePath() {
//                return basePath + super.getApplicationBasePath();
//            }
//        });
//    }
//
//
//    @ConfigurationProperties(
//            prefix = "swagger2"
//    )
//    @Data
//    static class Swagger2Properties extends Swagger2BaseProperties {
//        private Map<String, String> authMap = new LinkedHashMap<>();
//    }
//
//}

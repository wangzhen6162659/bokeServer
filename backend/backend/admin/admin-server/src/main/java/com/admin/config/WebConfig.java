package com.admin.config;

import com.admin.inertceptor.AppAuthRestInterceptor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.hengyunsoft.commons.handler.SpringMvcGlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author tyh
 * @createTime 2017-12-15 17:35
 */
@Configuration("webConfig")
@Primary
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);//排除空字段
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);//忽略未知字段
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//日期格式
        objectMapper.setDateFormat(outputFormat);

        SimpleModule simpleModule = new SimpleModule();

        /**
         *  将Long,BigInteger序列化的时候,转化为String
         */
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        simpleModule.addSerializer(BigInteger.class, ToStringSerializer.instance);

        objectMapper.registerModule(simpleModule);

        messageConverter.setObjectMapper(objectMapper);

        converters.add(messageConverter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ArrayList<String> commonPathPatterns = getExcludeCommonPathPatterns();
        registry.addInterceptor(getAuthRestInterceptor()).addPathPatterns("/**")
                .excludePathPatterns(commonPathPatterns.toArray(new String[]{}));
        super.addInterceptors(registry);
    }

    @Bean
    AppAuthRestInterceptor getAuthRestInterceptor() {
        return new AppAuthRestInterceptor();
    }

    private ArrayList<String> getExcludeCommonPathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/error",
                "/p/login/**",
                "/v2/api-docs",
                "/swagger-resources/**",
                "/cache/**",
                "/swagger-ui.html**",
        };
        Collections.addAll(list, urls);
        return list;
    }
    
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
    	
    	SpringMvcGlobalExceptionHandler springMvcGlobalExceptionHandler = new SpringMvcGlobalExceptionHandler();
    	springMvcGlobalExceptionHandler.setAllAjaxResponse(true);
    	exceptionResolvers.add(springMvcGlobalExceptionHandler);
    	super.configureHandlerExceptionResolvers(exceptionResolvers);
    }
}

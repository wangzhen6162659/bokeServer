package com.boke.demo.config;

import com.boke.demo.interceptor.TokenSetInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.Collections;

@Configuration("centerWebConfig")
@Primary
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        ArrayList<String> commonPathPatterns = getExcludeCommonPathPatterns();
        registry.addInterceptor(getTokenSetInterceptor()).addPathPatterns("/**").excludePathPatterns(commonPathPatterns.toArray(new String[]{}));
        super.addInterceptors(registry);
    }


    private ArrayList<String> getExcludeCommonPathPatterns() {
        ArrayList<String> list = new ArrayList<>();
        String[] urls = {
                "/error",
                "/v2/api-docs",
                "/swagger-resources/**",
                "/client/**",
                "/login/**",
                "/jwt/**"
        };
        Collections.addAll(list, urls);
        return list;
    }

    @Bean
    TokenSetInterceptor getTokenSetInterceptor() {
        return new TokenSetInterceptor();
    }
}

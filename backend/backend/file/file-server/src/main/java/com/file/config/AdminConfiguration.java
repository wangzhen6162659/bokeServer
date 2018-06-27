package com.file.config;

import com.hengyunsoft.base.id.IdGenerate;
import com.hengyunsoft.base.id.SnowflakeIDGenerate;
import com.hengyunsoft.commons.handler.GlobalExceptionHandler;
import feign.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdminConfiguration {
    /**
     * 全局异常处理
     *
     * @return
     */
    @Bean
    public GlobalExceptionHandler getGlobalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

    @Bean
    public IdGenerate getIdGenerate(@Value("${id-generator.machine-code:1}") Long machineCode) {
        return new SnowflakeIDGenerate(machineCode);
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        //NONE, 不记录日志 (默认)。
        //BASIC, 只记录请求方法和URL以及响应状态代码和执行时间。
        //HEADERS, 记录请求和应答的头的基本信息。
        //FULL, 记录请求和响应的头信息，正文和元数据。
        return feign.Logger.Level.FULL;
    }
}

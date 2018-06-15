package com.boke.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("boke.demo")
@Component
@Data
public class BokeWebappConfig {
    private String indexUrl;
}

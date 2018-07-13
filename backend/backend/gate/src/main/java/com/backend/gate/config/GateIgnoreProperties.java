package com.backend.gate.config;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author tyh
 * @createTime 2017-12-18 17:55
 */
@Data
@NoArgsConstructor
@ConfigurationProperties(GateIgnoreProperties.PREFIX)
@Configuration
public class GateIgnoreProperties {
    public static final String PREFIX = "gate.ignore";
    private List<String> startWithList = Lists.newArrayList();
}

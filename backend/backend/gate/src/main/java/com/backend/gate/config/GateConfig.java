package com.backend.gate.config;

import com.hengyunsoft.platform.commons.sec.IUserToken;
import com.hengyunsoft.platform.commons.sec.impl.BitEncryptUserToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateConfig {

	
    @Bean
    IUserToken userToken() {
    	
    	return new BitEncryptUserToken();
    }
}

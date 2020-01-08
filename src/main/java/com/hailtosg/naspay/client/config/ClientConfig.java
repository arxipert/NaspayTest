package com.hailtosg.naspay.client.config;

import com.hailtosg.naspay.authentication.AuthenticationInterceptor;
import com.hailtosg.naspay.authentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ClientConfig {

    private AuthenticationService authenticationService;

    @Autowired
    public ClientConfig(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getInterceptors().add(new AuthenticationInterceptor(authenticationService));
        return restTemplate;
    }
}

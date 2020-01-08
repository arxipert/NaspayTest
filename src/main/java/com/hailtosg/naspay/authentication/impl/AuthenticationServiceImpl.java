package com.hailtosg.naspay.authentication.impl;

import com.hailtosg.naspay.authentication.AccessToken;
import com.hailtosg.naspay.authentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private String apiTokenUrl;
    private AccessToken accessToken;
    private RestTemplate restTemplate;

    @Autowired
    public AuthenticationServiceImpl(
            @Value("${api-token-url}") String apiTokenUrl,
            @Value("${terminal-key}") String terminalKey,
            @Value("${terminal-secret}") String terminalSecret,
            RestTemplateBuilder restTemplateBuilder) {
        this.apiTokenUrl = apiTokenUrl;
        restTemplate = restTemplateBuilder.basicAuthentication(terminalKey, terminalSecret).build();
        accessToken = getFromApi();
    }

    @Override
    public AccessToken getAccessToken(){
        return accessToken;
    }

    private AccessToken getFromApi() {
        return restTemplate.getForObject(apiTokenUrl, AccessToken.class);
    }

}


package com.hailtosg.naspay.authentication;

import com.hailtosg.naspay.authentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthenticationInterceptor implements ClientHttpRequestInterceptor {

    private AuthenticationService authService;

    @Autowired
    public AuthenticationInterceptor(AuthenticationService authService) {
        this.authService = authService;
    }

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        AccessToken token = authService.getAccessToken();
        httpRequest.getHeaders().add("Authorization", "Bearer " + token.getToken());
        return clientHttpRequestExecution.execute(httpRequest, bytes);
    }
}

package com.hailtosg.naspay.client.impl;

import com.hailtosg.naspay.client.Transaction;
import com.hailtosg.naspay.client.service.NaspayClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class NaspayClientImpl implements NaspayClient {
    private final RestTemplate restTemplate;
    private final String apiUrl;

    @Autowired
    public NaspayClientImpl(
            @Value("${api-url}") String apiUrl,
            RestTemplate restTemplate) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
    }

    @Override
    public String getTransactionState(String transactionId) throws HttpClientErrorException {
        Transaction transaction =
            Optional.ofNullable(restTemplate
                .getForObject(apiUrl + "/transactions/" + transactionId, Transaction.class))
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        return transaction.getState();
    }
}

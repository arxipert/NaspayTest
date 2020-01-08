package com.hailtosg.naspay.client.service;

import org.springframework.web.client.HttpClientErrorException;

public interface NaspayClient {
    String getTransactionState(String transactionId) throws HttpClientErrorException;
}

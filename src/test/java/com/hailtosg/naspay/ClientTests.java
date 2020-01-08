package com.hailtosg.naspay;

import com.hailtosg.naspay.client.service.NaspayClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientTests {

    private static final String AUTHORIZED = "dbb46d0c4cfc4cdd9f923aa229106287";
    private static final String DECLINED = "5ce5fbd950294c4cbf3f3276e645668a";
    private static final String TIMEOUT = "8a0885e6526c4257ba213292a0d956b0";
    private static final String COMPLETED = "1261481f9625430887e155817e45ec33";
    private static final String NOTFOUND = "f33ae3006b074e649c1095ff8fb35e93";

    @Autowired
    private NaspayClient client;

    @Test
    public void stateIsAuthorizedTest() {
        assertEquals("AUTHORIZED", client.getTransactionState(AUTHORIZED));
    }

    @Test
    public void stateIsDeclinedTest() {
        assertEquals("DECLINED", client.getTransactionState(DECLINED));
    }

    @Test
    public void stateIsTimeoutTest() {
        assertEquals("TIMEOUT", client.getTransactionState(TIMEOUT));
    }

    @Test
    public void stateIsCompletedTest() {
        assertEquals("COMPLETED", client.getTransactionState(COMPLETED));
    }

    @Test
    public void stateNotFoundTest() {
        assertThrows(HttpClientErrorException.class, () -> {
            client.getTransactionState(NOTFOUND);
        });
    }
}

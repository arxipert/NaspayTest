package com.hailtosg.naspay.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class AccessToken{
    @JsonProperty("access_token")
    private String token;
    @JsonProperty("token_type")
    private String tokenType;
}

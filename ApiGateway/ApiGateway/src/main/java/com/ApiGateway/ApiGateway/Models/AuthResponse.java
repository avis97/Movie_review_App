package com.ApiGateway.ApiGateway.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Collections;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthResponse{

    private String userId;
    private String token;
    private String refreshToken;
    private long expireAt;
    private Collection<String> auth;
}

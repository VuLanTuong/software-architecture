package com.example.microserviceredis2.service;

import com.example.microserviceredis2.entity.Token;

public interface TokenService {
    Token createToken(Token token);

    Token findByToken(String token);
}

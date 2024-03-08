package com.example.microserviceredis2.repositories;

import com.example.microserviceredis2.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository
        extends JpaRepository<Token, Long> {
    Token findByToken(String token);
}

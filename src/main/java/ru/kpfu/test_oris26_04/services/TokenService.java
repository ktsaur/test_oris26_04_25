package ru.kpfu.test_oris26_04.services;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TokenService {
    public String generateToken() {
        return UUID.randomUUID().toString();
    }
}

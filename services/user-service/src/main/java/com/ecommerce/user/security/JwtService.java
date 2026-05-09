package com.ecommerce.user.security;

import java.time.Instant;
import java.util.Base64;
import java.util.Map;

public class JwtService {
    public String generateAccessToken(String subject, String role) {
        return Base64.getEncoder().encodeToString((subject + ":" + role + ":" + Instant.now().getEpochSecond()).getBytes());
    }
    public String generateRefreshToken(String subject) {
        return Base64.getEncoder().encodeToString((subject + ":refresh:" + Instant.now().plusSeconds(86400).getEpochSecond()).getBytes());
    }
    public Map<String, String> rotate(String subject, String role) {
        return Map.of("accessToken", generateAccessToken(subject, role), "refreshToken", generateRefreshToken(subject));
    }
}

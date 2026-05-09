package com.ecommerce.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody Map<String, String> payload) {
        return ResponseEntity.ok(Map.of("message", "User registered", "email", payload.getOrDefault("email", "")));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login() {
        return ResponseEntity.ok(Map.of("accessToken", "sample-jwt", "refreshToken", "sample-refresh-token"));
    }
}

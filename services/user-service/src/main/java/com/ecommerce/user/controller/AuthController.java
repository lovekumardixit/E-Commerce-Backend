package com.ecommerce.user.controller;

import com.ecommerce.user.dto.RegisterRequest;
import com.ecommerce.user.entity.User;
import com.ecommerce.user.security.JwtService;
import com.ecommerce.user.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserService userService;
    private final JwtService jwtService;

    public AuthController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, Object>> register(@Valid @RequestBody RegisterRequest payload) {
        User user = userService.register(payload);
        return ResponseEntity.ok(Map.of("user", user, "tokens", jwtService.rotate(user.getEmail(), user.getRole())));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestParam String email, @RequestParam(defaultValue = "ROLE_CUSTOMER") String role) {
        return ResponseEntity.ok(jwtService.rotate(email, role));
    }

    @PostMapping("/refresh")
    public ResponseEntity<Map<String, String>> refresh(@RequestParam String email, @RequestParam(defaultValue = "ROLE_CUSTOMER") String role) {
        return ResponseEntity.ok(jwtService.rotate(email, role));
    }
}

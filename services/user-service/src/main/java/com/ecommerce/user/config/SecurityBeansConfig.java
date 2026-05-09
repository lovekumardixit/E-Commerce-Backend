package com.ecommerce.user.config;

import com.ecommerce.user.security.JwtService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityBeansConfig {
    @Bean
    public JwtService jwtService() {
        return new JwtService();
    }
}

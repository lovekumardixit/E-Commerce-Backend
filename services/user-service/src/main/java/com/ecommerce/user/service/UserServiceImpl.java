package com.ecommerce.user.service;

import com.ecommerce.user.dto.RegisterRequest;
import com.ecommerce.user.entity.User;
import com.ecommerce.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(RegisterRequest request) {
        User user = new User();
        user.setName(request.fullName());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setRole("ROLE_CUSTOMER");
        return userRepository.save(user);
    }
}

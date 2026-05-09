package com.ecommerce.user.controller;

import com.ecommerce.user.entity.User;
import com.ecommerce.user.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserProfileController {
    private final UserRepository userRepository;

    public UserProfileController(UserRepository userRepository) { this.userRepository = userRepository; }

    @GetMapping
    public Page<User> all(Pageable pageable) { return userRepository.findAll(pageable); }
}

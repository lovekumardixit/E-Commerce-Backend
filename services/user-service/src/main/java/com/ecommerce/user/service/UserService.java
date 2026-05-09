package com.ecommerce.user.service;

import com.ecommerce.user.dto.RegisterRequest;
import com.ecommerce.user.entity.User;

public interface UserService {
    User register(RegisterRequest request);
}

package com.example.ecommerce.service;

import com.example.ecommerce.dto.UserRegisterRequest;
import com.example.ecommerce.model.User;

public interface UserService {
    User getUserById(Integer userId);

    Integer register(UserRegisterRequest userRegisterRequest);

}

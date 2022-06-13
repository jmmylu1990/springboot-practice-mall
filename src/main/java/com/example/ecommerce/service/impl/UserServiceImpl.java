package com.example.ecommerce.service.impl;

import com.example.ecommerce.dao.UserDao;
import com.example.ecommerce.dto.UserRegisterRequest;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.UserService;
import com.sun.org.slf4j.internal.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest) {
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());
         if(user!=null){
             log.warn("該 email {} 已經被 {} 註冊" ,userRegisterRequest.getEmail(),user.getUserId());
                     throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
         }
        return userDao.createUser(userRegisterRequest);
    }
}

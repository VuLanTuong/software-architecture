package com.example.microserviceredis2.service;


import com.example.microserviceredis2.authen.UserPrincipal;
import com.example.microserviceredis2.entity.User;


public interface UserService {
    User createUser(User user);
    UserPrincipal findByUsername(String username);
}

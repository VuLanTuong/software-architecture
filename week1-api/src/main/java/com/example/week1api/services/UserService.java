package com.example.week1api.services;

import com.example.week1api.models.Product;
import com.example.week1api.models.User;
import com.example.week1api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUser(){

        return userRepository.findAll();
    }

}

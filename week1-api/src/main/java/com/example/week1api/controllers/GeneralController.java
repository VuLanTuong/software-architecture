package com.example.week1api.controllers;

import com.example.week1api.models.Product;
import com.example.week1api.models.User;
import com.example.week1api.services.ProductService;
import com.example.week1api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class GeneralController {
    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    RestTemplate restTemplate = new RestTemplate();


    @GetMapping("/products")
    List<Product> getAllProduct(){
        return productService.getAllProduct();
    }
    @GetMapping("/products/{id}")
    Product getUserById(@PathVariable long id){
        User user = restTemplate.getForObject("http://localhost:8080/users/"+id, User.class);
        return productService.findProductById(id);
    }


    @GetMapping("/users")
    List<User> getAllUser(){
        return userService.getAllUser();
    }
}


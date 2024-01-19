package com.example.week1api.controllers;

import com.example.week1api.models.Order;
import com.example.week1api.models.Product;
import com.example.week1api.models.User;
import com.example.week1api.services.OrderService;
import com.example.week1api.services.ProductService;
import com.example.week1api.services.UserService;
import org.aspectj.weaver.ast.Or;
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

    @Autowired
    private OrderService orderService;

    RestTemplate restTemplate = new RestTemplate();


    @GetMapping("/products")
    List<Product> getAllProduct(){
        return productService.getAllProduct();
    }
    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable long id){
//        User user = restTemplate.getForObject("http://localhost:8080/products/"+id, User.class);
        Product product = productService.findProductById(id);
        return product;
    }

    @GetMapping("/users")
    List<User> getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/orders")
    List<Order> getAllOrder(){
        List<Order> orders = orderService.findAllOrder();
        return orders;
    }

    @GetMapping("/orders/{id}")
    Order getOrderById(@PathVariable long id){
//        User user = restTemplate.getForObject("http://localhost:8080/products/"+id, User.class);
        Order order = orderService.findById(id);
        return order;
    }


}


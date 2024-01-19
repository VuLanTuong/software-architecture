package com.example.week2apigateway.controller;

import com.example.week2apigateway.dto.Order;
import com.example.week2apigateway.dto.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@RestController
public class OrderController {
    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/orders")
    List<Order> getAll(){
//        return Collections.singletonList(restTemplate.getForObject("http://localhost:8080/products", Product.class));

//        List<Product> products = List.of(restTemplate.getForObject("http://localhost:8080/products", Product.class));

        String json = restTemplate.getForObject("http://localhost:8080/orders", String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        List<Order> result = new ArrayList<>();
        try{
            Order[] orders = objectMapper.readValue(json, Order[].class);
            for (Order order : orders ) {
               Order order1 = new Order();
               order1.setId(order.getId());
               order1.setName(order.getName());
                result.add(order1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return result;
    }

    @GetMapping("/orders/{id}")
    Order getOrderById(@PathVariable long id) throws JsonProcessingException {
        String json = restTemplate.getForObject("http://localhost:8080/orders/"+id, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = objectMapper.readValue(json, Order.class);
        return order;
    }



}

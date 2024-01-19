package com.example.week2apigateway.controller;

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
public class ProductController {

    RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/products")
    List<Product> getAll(){
        String json = restTemplate.getForObject("http://localhost:8080/products", String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        List<Product> result = new ArrayList<>();
        try{
            Product[] products = objectMapper.readValue(json, Product[].class);
            for (Product product : products ) {
                Product product1 = new Product();
                product1.setId(product.getId());
                product1.setName(product.getName());
                product1.setUser(product.getUser());
                result.add(product1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable long id) throws JsonProcessingException {
        String json = restTemplate.getForObject("http://localhost:8080/products/"+id, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        Product product = objectMapper.readValue(json, Product.class);
        return product;
    }


}

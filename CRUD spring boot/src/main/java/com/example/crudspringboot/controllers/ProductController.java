package com.example.crudspringboot.controllers;

import com.example.crudspringboot.model.Product;
import com.example.crudspringboot.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping("/")
    public List<Product> getProduct(){
        return productService.getAllProduct();
    }
    @PostMapping("/insert")
    public void insertProduct(
                              @RequestParam("name") String name,
                              @RequestParam("description") String description){

        Product product =  new Product( name, description);
        productService.insertProduct(product);
    }

    @PostMapping("/update")
    public void updateProduct(
            @RequestParam("name") String name,
            @RequestParam("description") String description){

        Product product =  new Product( name, description);
        productService.updateProduct(product);
    }




}

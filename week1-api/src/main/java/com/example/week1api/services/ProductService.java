package com.example.week1api.services;

import com.example.week1api.models.Product;
import com.example.week1api.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProduct(){

        return productRepository.findAll();
    }

    public Product findProductById(long id){
        Optional<Product> product = productRepository.findById(id);

        if(product.isPresent())
            return product.get();
        return null;
    }
}

package com.example.crudspringboot.services;

import com.example.crudspringboot.model.Product;
import com.example.crudspringboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(long id){
        return productRepository.getProductById(id);
    }

    public void insertProduct(Product product){
        productRepository.save(product);

    }

//    public void removeProduct(long id){
//        productRepository.removeProductById(id);
//    }

    public void updateProduct(Product product){
        productRepository.save(product);
    }

    public List<Product> getAllProduct(){
        return productRepository.getAllProduct();
    }
}

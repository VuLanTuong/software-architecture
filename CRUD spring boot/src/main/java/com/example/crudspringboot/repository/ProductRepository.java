package com.example.crudspringboot.repository;

import com.example.crudspringboot.model.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("""
        select p from Product  p where p.id = :id
        """)
    Product getProductById(long id);

//    boolean insertProduct(Product product);

//    @Transactional
//    void removeProductById(long id);
//
//    void updateById(long id);

    @Query("""
        select p from Product  p
        """)
    List<Product> getAllProduct();




}

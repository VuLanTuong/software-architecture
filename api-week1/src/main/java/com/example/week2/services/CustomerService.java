package com.example.week2.services;

import com.example.week2.models.Customer;
import com.example.week2.repositories.CustomerRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.Optional;

public class CustomerService {
    private final CustomerRepository customerRepository;
    private EntityManager entityManager;


    public CustomerService(){

        entityManager =  Persistence.createEntityManagerFactory("week2")
                .createEntityManager();
        this.customerRepository = new CustomerRepository();
    }

    public Optional<Customer> findAccount(String email, String password){
        return customerRepository.findAccount(email, password);
    }
}

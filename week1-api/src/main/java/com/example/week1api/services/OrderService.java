package com.example.week1api.services;

import com.example.week1api.models.Order;
import com.example.week1api.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAllOrder(){
        return orderRepository.findAll();
    }

    public Order findById(long id){
        Optional<Order> orderOptional = orderRepository.findById(id);

        if (orderOptional.isPresent()){
            Order order = orderOptional.get();

            return order;
        }
        return null;
    }
}

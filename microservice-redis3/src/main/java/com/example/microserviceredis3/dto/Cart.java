package com.example.microserviceredis3.dto;

import com.example.microserviceredis3.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
// class just get value
public class Cart {
    private int quantity;
    private Product product;
}

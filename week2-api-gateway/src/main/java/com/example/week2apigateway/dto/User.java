package com.example.week2apigateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
}

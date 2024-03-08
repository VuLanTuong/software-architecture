package com.example.microserviceredis2.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data // lombok
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    private String password;
}

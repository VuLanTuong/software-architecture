package com.example.microserviceredis2.repositories;


import com.example.microserviceredis2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User save(User user);
}

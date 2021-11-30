package com.example.demo.infraestructure.userInfraestructure;

import java.util.UUID;

import com.example.demo.domain.userDomain.User;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

public interface UserR2dbcRepository extends ReactiveCrudRepository<User, UUID> {
    @Query("SELECT name FROM users WHERE (name LIKE CONCAT('%', :name, '%')) ORDER BY name;")
    Flux<User> findByName(String name);
    
    @Query("SELECT email FROM users WHERE name = :name LIMIT 1;")
    Mono<Boolean> exists(String mail);
}


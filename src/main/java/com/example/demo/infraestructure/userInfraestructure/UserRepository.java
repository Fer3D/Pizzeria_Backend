package com.example.demo.infraestructure.userInfraestructure;

import java.util.UUID;

import com.example.demo.domain.userDomain.User;
import com.example.demo.domain.userDomain.UserProjection;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, UUID> {
    @Query("SELECT id, name, lastName, email FROM User WHERE (name LIKE CONCAT('%', :name, '%')) ORDER BY name;")
    Flux<UserProjection> findByCriteria(String name);

    @Query("SELECT email FROM users WHERE name = :name LIMIT 1;")
    Mono<Boolean> existsByEmail(String name);
}


package com.example.demo.domain.userDomain;

import java.util.UUID;

import reactor.core.publisher.Mono;

public interface UserWriteRepository {
    public Mono<User> findById(UUID id); 
    public Mono<User> add(User user);
    public Mono<User> update(User user);
}



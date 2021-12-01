package com.example.demo.application.userApplication;

import com.example.demo.domain.userDomain.User;

import reactor.core.publisher.Mono;

public interface UserApplication {
    Mono<User> add(CreateUserDTO createUserDTO);
}

package com.example.demo.application.userApplication;

import reactor.core.publisher.Mono;

public interface UserApplication {
    Mono<UserOutDTO> add(CreateUserDTO createUserDTO);
}

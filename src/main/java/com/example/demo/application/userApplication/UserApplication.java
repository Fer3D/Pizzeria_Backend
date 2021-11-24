package com.example.demo.application.userApplication;

import java.util.UUID;

import com.example.demo.domain.userDomain.UserProjection;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserApplication {

    public Mono<UserDTO> add(CreateUserDTO dto);
    public Mono<UserDTO> get(UUID id);
    public Mono<UserDTO> update(UUID id, UpdateUserDTO dto);
    public Flux<UserProjection> getAll(String name);
}

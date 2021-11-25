package com.example.demo.application.userApplication;

import reactor.core.publisher.Mono;

public interface UserApplication {

    public Mono<UserDTO> add(CreateUserDTO dto);

}

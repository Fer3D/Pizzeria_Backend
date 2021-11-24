package com.example.demo.controller;

import java.util.UUID;

import javax.validation.Valid;

import com.example.demo.application.userApplication.CreateUserDTO;
import com.example.demo.application.userApplication.UpdateUserDTO;
import com.example.demo.application.userApplication.UserApplication;
import com.example.demo.application.userApplication.UserDTO;
import com.example.demo.domain.userDomain.UserProjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserApplication userApplication;

    @Autowired
    public UserController(final UserApplication userApplication){
        this.userApplication = userApplication;
    }
    
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<UserDTO>> create(@Valid @RequestBody CreateUserDTO dto) {
        Mono<UserDTO> userDTO = this.userApplication.add(dto);
        return userDTO.map(user -> ResponseEntity.ok(user)).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public Mono<ResponseEntity<UserDTO>> update(@Valid @PathVariable UUID id, @Valid @RequestBody UpdateUserDTO dto) {
        Mono<UserDTO> userDTO = this.userApplication.update(id, dto);
        return userDTO.map(user -> ResponseEntity.ok(user)).defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<UserProjection> getAll(
        @RequestParam(required = false) String email){
        return this.userApplication.getAll(email);
    }

}
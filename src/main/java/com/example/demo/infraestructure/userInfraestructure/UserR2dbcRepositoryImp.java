package com.example.demo.infraestructure.userInfraestructure;

import java.util.UUID;

import com.example.demo.domain.userDomain.User;
import com.example.demo.domain.userDomain.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public class UserR2dbcRepositoryImp implements UserRepository{

    private final UserR2dbcRepository userR2dbcRepository;

    @Autowired
    public UserR2dbcRepositoryImp(final UserR2dbcRepository userR2dbcRepository){
        this.userR2dbcRepository = userR2dbcRepository;
    }   

    @Override
    public Mono<User> add(User user) {
        return this.userR2dbcRepository.save(user);
    }

    @Override
    public Mono<User>findById(UUID id) {
        return this.userR2dbcRepository.findById(id);
    }

    @Override
    public Mono<Boolean>existsByField(String email) {
        return Mono.sequenceEqual(this.userR2dbcRepository.exists(email), Mono.just(1));
    }


}
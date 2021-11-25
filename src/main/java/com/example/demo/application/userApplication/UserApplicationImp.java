package com.example.demo.application.userApplication;


import com.example.demo.domain.userDomain.User;
import com.example.demo.domain.userDomain.UserWriteRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.modelmapper.ModelMapper;

import reactor.core.publisher.Mono;

@Service
public class UserApplicationImp {

    private final UserWriteRepository userWriteRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserApplicationImp(final UserWriteRepository userWriteRepository, 
    final ModelMapper modelMapper) {
        this.userWriteRepository = userWriteRepository;
        this.modelMapper = modelMapper;
    }

    public Mono<UserDTO> add(CreateUserDTO createuserdto) {
        User user = modelMapper.map(createuserdto, User.class);
        return this.userWriteRepository.add(user).flatMap(entity -> Mono.just(this.modelMapper.map(entity, UserDTO.class)));
    }
    
}

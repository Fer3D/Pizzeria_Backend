package com.example.demo.application.userApplication;

import com.example.demo.domain.userDomain.User;
import com.example.demo.domain.userDomain.UserRepository;
import com.example.demo.core.ApplicationBase;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Mono;

@Service
public class UserApplicationImp extends ApplicationBase<User, UUID> implements UserApplication {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserApplicationImp(UserRepository userRepository, ModelMapper modelMapper) {
        super(userRepository::findById);
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public Mono<UserOutDTO> add(CreateUserDTO createUserDTO) {
        User user = modelMapper.map(createUserDTO, User.class);
        return this.userRepository.add(user).flatMap(entity -> Mono.just(this.modelMapper.map(entity, UserOutDTO.class)));
    }

}

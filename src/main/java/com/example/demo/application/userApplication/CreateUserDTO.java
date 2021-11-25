package com.example.demo.application.userApplication;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class CreateUserDTO {

    @NotBlank
    private String name;
    
    @NotBlank
    private String lastName;
    
    @NotBlank @Email
    private String email;

    @NotBlank
    private String password;
}
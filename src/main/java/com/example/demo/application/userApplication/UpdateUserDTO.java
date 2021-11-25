package com.example.demo.application.userApplication;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;


public @Getter @Setter class UpdateUserDTO {

    @NotBlank
    private String name;
    
    @NotBlank
    private String lastName;

    @NotBlank
    private String password;

    @NotBlank
    private String newPassword;

}
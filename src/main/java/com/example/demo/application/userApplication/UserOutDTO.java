package com.example.demo.application.userApplication;

import lombok.Getter;
import lombok.Setter;

public @Getter @Setter class UserOutDTO {
    
    private String type;
    private String token;
    private String expireSeconds = "3600";
    private String refreshToken;
    
}

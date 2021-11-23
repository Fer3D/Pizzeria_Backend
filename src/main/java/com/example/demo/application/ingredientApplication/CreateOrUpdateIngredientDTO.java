package com.example.demo.application.ingredientApplication;

import java.util.UUID;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Validated
public @Getter @Setter class CreateOrUpdateIngredientDTO {
    private String name;
    private UUID id;
    
}

package com.example.demo.IngredientDTO;

import java.math.BigDecimal;

import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

//@Validated
public @Getter @Setter class CreateOrUpdateIngredientDTO {
    private String name;
    private BigDecimal price;
}

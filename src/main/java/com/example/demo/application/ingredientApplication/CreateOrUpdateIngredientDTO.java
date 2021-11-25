package com.example.demo.application.ingredientApplication;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Setter;

@Data
public @Setter class CreateOrUpdateIngredientDTO {
    
    private String name;
    
    private BigDecimal price;
    
}

package com.example.demo.application.ingredientApplication;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.Setter;

@Data
public @Setter class CreateOrUpdateIngredientDTO {
    
    private String name;
    @NotNull @Digits(integer = 3, fraction = 2) @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;
    
}

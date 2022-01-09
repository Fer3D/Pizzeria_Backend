package com.example.demo.application.ingredientApplication;

import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Validated
public @Getter @Setter class CreateOrUpdateIngredientDTO {

    @NotBlank(message="name is mandatory") @Size(min=2, max=45)
    private String name;
    
    
    @NotNull @Digits(integer = 3, fraction = 2) @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;
    
}

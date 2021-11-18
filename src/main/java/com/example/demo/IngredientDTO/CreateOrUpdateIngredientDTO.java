package com.example.demo.IngredientDTO;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;


public @Getter @Setter class CreateOrUpdateIngredientDTO {
    private String name;
    private BigDecimal price;
}

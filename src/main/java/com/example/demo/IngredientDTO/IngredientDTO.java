
package com.example.demo.IngredientDTO;



import java.math.BigDecimal;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;


public @Getter @Setter class IngredientDTO {
    private UUID id;
    private String name;
    private BigDecimal price;
}

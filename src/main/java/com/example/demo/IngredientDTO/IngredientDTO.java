
package com.example.demo.IngredientDTO;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;


@Data
@Builder
public class IngredientDTO<T> {
    UUID id ;
    String name;
    BigDecimal price;
    Map<String, T> data;
}

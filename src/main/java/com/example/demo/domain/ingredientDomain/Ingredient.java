package com.example.demo.domain.ingredientDomain;
import java.math.BigDecimal;

import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import com.example.demo.core.EntityBase;

import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Table("ingredients")
public @NoArgsConstructor @Setter class Ingredient extends EntityBase {

    @NotBlank
    private String name;

    @NotNull @Digits(integer = 3, fraction = 2) @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;

    @Override
    public String toString() {
        return String.format("Ingredient {id: %s, name: %s, price: %s}", this.getId(), this.getName(), this.getPrice());
    }

    private BigDecimal getPrice() {
        return price;
    }

    private String getName() {
        return name;
    }
   

}


package com.example.demo.domain.ingredientDomain;
import java.math.BigDecimal;

import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import com.example.demo.core.EntityBase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table("ingredients")
public @NoArgsConstructor @Getter @Setter class Ingredient extends EntityBase {

    @NotBlank
    private String name;

    @NotNull @Digits(integer = 3, fraction = 2) @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal price;

    @Override
    public boolean isNew() {
        return this.isThisNew();
    }
   

}


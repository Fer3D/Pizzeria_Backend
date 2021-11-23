package com.example.demo.domain.ingredientDomain;
import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotBlank;


import com.example.demo.core.EntityBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table("ingredients")
public @NoArgsConstructor @Getter @Setter class Ingredient extends EntityBase {

    @NotBlank
    @Column ("id")
    private  UUID id;

    @NotBlank
    @Column("name")
    private String name;

    @Column("price")
    private BigDecimal price;

    @Override
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setThisNew(boolean b) {
    }


}

package com.example.demo.domain.ingredientDomain;
import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.example.demo.domain.EntityBase;

import io.micronaut.data.annotation.Id;
import lombok.Getter;
import lombok.Setter;

@Table 
public @Getter @Setter class Ingredient extends EntityBase {
    @Id
    @Column
    private UUID id;
    @Column
    public String name;
    @Column
    public BigDecimal price;
    
    @Override
    public UUID getId() {
        return id;
    }
      
}
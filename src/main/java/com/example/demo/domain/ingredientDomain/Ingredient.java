package com.example.demo.domain.ingredientDomain;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;



@Table("Ingredient")
public  class Ingredient {
    @Id
    @Column("id")
    public UUID id;

    @Column("name")
    public String name;

    @Column("prize")
    public BigDecimal prize;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public void setPrize(BigDecimal prize) {
        this.prize = prize;
    }

    public void setThisNew(boolean b) {
    }

    

}

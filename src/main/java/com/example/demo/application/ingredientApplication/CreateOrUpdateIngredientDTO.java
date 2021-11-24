package com.example.demo.application.ingredientApplication;

import java.util.UUID;

import lombok.Data;
import lombok.Setter;

@Data
public @Setter class CreateOrUpdateIngredientDTO {
    
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    private UUID id;
    
}

package com.example.demo.application.ingredientApplication;
//import java.util.UUID;

import com.example.demo.IngredientDTO.CreateOrUpdateIngredientDTO;
import com.example.demo.IngredientDTO.IngredientDTO;

import reactor.core.publisher.Mono;

public interface IngredientApplication extends Add<CreateOrUpdateIngredientDTO, IngredientDTO> {
    public Mono<IngredientDTO> add(CreateOrUpdateIngredientDTO dto);   
}

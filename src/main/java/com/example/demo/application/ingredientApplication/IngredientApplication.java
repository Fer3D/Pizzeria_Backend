package com.example.demo.application.ingredientApplication;
//import java.util.UUID;

import com.example.demo.IngredientDTO.CreateOrUpdateIngredientDTO;
import com.example.demo.IngredientDTO.IngredientDTO;
import com.example.demo.infraestructure.Add;

import reactor.core.publisher.Mono;

public interface IngredientApplication extends Add<CreateOrUpdateIngredientDTO, IngredientDTO> {
    public Mono<IngredientDTO> add(CreateOrUpdateIngredientDTO dto);

    
    /*public Mono<IngredientDTO> get(UUID id);
    public Mono<IngredientDTO> update(UUID id, CreateOrUpdateIngredientDTO dto);
    public Mono<IngredientDTO> delete(UUID id);*/
   
}

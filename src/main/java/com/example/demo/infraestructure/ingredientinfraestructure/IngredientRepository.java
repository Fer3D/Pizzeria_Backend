package com.example.demo.infraestructure.ingredientinfraestructure;

import java.util.UUID;

import com.example.demo.IngredientDTO.IngredientDTO;
import com.example.demo.domain.ingredientDomain.Ingredient;



import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Mono;


public interface IngredientRepository extends ReactiveCrudRepository<Ingredient, UUID> {

    Mono<IngredientDTO> add(Ingredient ingredient);
    

   
}

package com.example.demo.domain.ingredientDomain;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;


public interface IngredientRepository extends ReactiveCrudRepository<Ingredient, UUID> {

    Mono<Ingredient> add(Ingredient ingredient);
   
}

package com.example.demo.domain.ingredientDomain;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface IngredientRepository extends ReactiveCrudRepository<Ingredient, UUID> {

    Mono<Ingredient> add(Ingredient ingredient);

    Flux<IngredientProjection> getAll(String name, int page, int size);
   
}

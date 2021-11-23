package com.example.demo.domain.ingredientDomain;


import reactor.core.publisher.Flux;

public interface IngredientReadRepository {

    Flux<IngredientProjection> getAll(String name, int page, int size);
   
}

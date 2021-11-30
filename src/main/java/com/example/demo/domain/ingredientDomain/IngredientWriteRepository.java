package com.example.demo.domain.ingredientDomain;


import java.util.UUID;

import com.example.demo.core.functionalInterfaces.FindById;

import org.springframework.data.repository.query.Param;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IngredientWriteRepository extends FindById<Ingredient, UUID>  {

    public Mono<Ingredient> add(Ingredient ingredient);
    public Mono<Ingredient> update(Ingredient ingredient);
    public Mono<Void> delete(Ingredient ingredient);
    public Flux<IngredientProjection> getAll(String name, int page, int size);
    public Mono<Integer> existByField(@Param(value="name") String name);
    
}

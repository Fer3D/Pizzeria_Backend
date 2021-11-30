package com.example.demo.domain.ingredientDomain;


import java.util.UUID;

import com.example.demo.core.functionalInterfaces.ExistByField;
import com.example.demo.core.functionalInterfaces.FindById;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IngredientWriteRepository extends FindById<Ingredient, UUID>, ExistByField {

    public Mono<Ingredient> add(Ingredient ingredient);
    public Mono<Ingredient> update(Ingredient ingredient);
    public Mono<Void> delete(Ingredient ingredient);
    public Flux<IngredientProjection> getAll(String name, int page, int size);
   

}

package com.example.demo.infraestructure.ingredientinfraestructure;
import java.util.UUID;

import com.example.demo.domain.ingredientDomain.Ingredient;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface IngredientRepositoryInfract extends ReactiveCrudRepository<Ingredient, UUID>{
    @Query("SELECT CASE WHEN COUNT(ingredient)>0 THEN true ELSE false END FROM ingredient WHERE name = :name")
    Mono<Boolean> existsByName(String name);
}

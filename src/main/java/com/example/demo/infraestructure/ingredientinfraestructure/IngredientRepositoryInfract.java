package com.example.demo.infraestructure.ingredientinfraestructure;
import java.util.UUID;

import com.example.demo.domain.ingredientDomain.Ingredient;
import com.example.demo.domain.ingredientDomain.IngredientProjection;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IngredientRepositoryInfract extends ReactiveCrudRepository<Ingredient, UUID>{
    @Query("SELECT CASE WHEN COUNT(ingredient)>0 THEN true ELSE false END FROM ingredient WHERE name = :name")
    Mono<Boolean> existsByName(String name);

    @Query("SELECT id, name, price FROM Ingredient WHERE (:name is NULL OR name LIKE concat('%', :name, '%')) limit :size offset :page")
    Flux<IngredientProjection> findByName(String name);
}

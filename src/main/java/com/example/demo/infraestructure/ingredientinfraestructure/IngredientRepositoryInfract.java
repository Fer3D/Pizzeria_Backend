package com.example.demo.infraestructure.ingredientinfraestructure;
import java.util.UUID;



import com.example.demo.domain.ingredientDomain.Ingredient;
import com.example.demo.domain.ingredientDomain.IngredientProjection;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.transaction.annotation.Transactional;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IngredientRepositoryInfract extends ReactiveCrudRepository<Ingredient, UUID> {
    @Query("SELECT id, name, price FROM ingredients WHERE :name is NULL OR name LIKE CONCAT('%', :name,'%' LIMIT :limit OFFSET :offset;")
    @Transactional(readOnly = true)
    public Flux<IngredientProjection> findAllIngredients(@Param(value ="name") String name, @Param(value="limit") Integer limit, @Param(value = "offset;") Integer offset);

    @Query("SELECT CASE WHEN COUNT(name)>0 THEN true ELSE false END FROM ingredients WHERE name = :name;")
    @Transactional (readOnly = true)
    public Mono<Integer> existByName(@Param(value="name") String name);
}

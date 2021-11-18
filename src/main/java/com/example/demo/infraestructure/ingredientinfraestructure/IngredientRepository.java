package com.example.demo.infraestructure.ingredientinfraestructure;

import java.util.UUID;

import com.example.demo.IngredientDTO.IngredientDTO;
import com.example.demo.application.ingredientApplication.IngredientApplication;
import com.example.demo.domain.ingredientDomain.Ingredient;


import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IngredientRepository extends ReactiveCrudRepository<Ingredient, UUID> {
    @Query("SELECT id, name, price FROM Ingredient WHERE (:name is NULL OR name LIKE '%:name%')")
    Flux<IngredientApplication> findByName(String name, Pageable pageable); /*Spring Boot usa el complemento Pageable para implementar paginación y consulta. 
    //Una interfaz definida en la biblioteca de datos. ... A través de esta interfaz, podemos obtener toda la información relacionada con la paginación 
    (como pageNumber, pageSize, etc. .).*/

    @Query("SELECT CASE WHEN COUNT(ingredient)>0 THEN true ELSE false END FROM ingredient WHERE name = :name")
    Mono<Boolean> existsByName(String name);

    Mono<IngredientDTO> add(Ingredient ingredient);
}
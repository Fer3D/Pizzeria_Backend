package com.example.demo.application.ingredientApplication;

import java.util.UUID;

import javax.validation.Valid;

import reactor.core.publisher.Mono;

public interface IngredientApplication {
    public Mono<IngredientDTO> add(CreateOrUpdateIngredientDTO dto);
    public Mono<IngredientDTO> get(@Valid UUID id);
    public Mono<IngredientDTO> update(UUID id, CreateOrUpdateIngredientDTO dto);
    public Mono<Void> delete(UUID id);
}

package com.example.demo.infraestructure.ingredientinfraestructure;

import java.util.UUID;

import com.example.demo.domain.ingredientDomain.Ingredient;
import com.example.demo.domain.ingredientDomain.IngredientProjection;
import com.example.demo.domain.ingredientDomain.IngredientReadRepository;
import com.example.demo.domain.ingredientDomain.IngredientWriteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class IngredientRepositoryImpl implements IngredientWriteRepository, IngredientReadRepository {
    
    private final IngredientRepositoryInfract ingredientRepositoryInfract;

    @Autowired
    public IngredientRepositoryImpl(IngredientRepositoryInfract ingredientRepositoryInfract){
        this.ingredientRepositoryInfract = ingredientRepositoryInfract;
    }

    @Override
    public Mono<Ingredient> add(Ingredient ingredient) {
        return this.ingredientRepositoryInfract.save(ingredient);
    }

    @Override
    public Mono<Ingredient>findById(UUID id) {
        return this.ingredientRepositoryInfract.findById(id);
    }

    @Override
    public Mono<Ingredient> update(Ingredient ingredient) {
        return this.ingredientRepositoryInfract.save(ingredient);
    }

    @Override
    public Mono<Void> delete(Ingredient ingredient) {
        return this.ingredientRepositoryInfract.delete(ingredient);
    }

    @Override
    public Flux<IngredientProjection> getAll(String name, int page, int size) {
        return this.ingredientRepositoryInfract.findByName(name,
        PageRequest.of(page, size));
    }

    @Override
    public Mono<Boolean> exists(String name) {
        return this.ingredientRepositoryInfract.existsByName(name);
    }
}
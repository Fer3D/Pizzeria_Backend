package com.example.demo.infraestructure.ingredientinfraestructure;

import com.example.demo.domain.ingredientDomain.IngredientRepository;

import java.util.UUID;

import com.example.demo.domain.ingredientDomain.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class IngredientRepositoryImpl implements IngredientRepository {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientRepositoryImpl (IngredientRepository ingredientepository){
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Mono<Ingredient> add(Ingredient ingredient) {
        return this.ingredientRepository.save(ingredient);
    }
}

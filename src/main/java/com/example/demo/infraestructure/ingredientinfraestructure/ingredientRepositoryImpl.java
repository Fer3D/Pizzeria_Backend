package com.example.demo.infraestructure.ingredientinfraestructure;


import java.util.UUID;
import com.example.demo.domain.ingredientDomain.Ingredient;
import com.example.demo.domain.ingredientDomain.IngredientWriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import lombok.Getter;
import lombok.Setter;
import reactor.core.publisher.Mono;

@Repository
public @Getter @Setter class IngredientRepositoryImpl implements IngredientWriteRepository {
    
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
    public Mono<Ingredient> findById(UUID id) {
       return this.ingredientRepositoryInfract.findById(id);
    }

    @Override
    public Mono<Boolean> exists(String name) {
        return this.ingredientRepositoryInfract.existsByName(name);
    }

    @Override
    public Mono<Ingredient> update(Ingredient ingredient) {
        return this.ingredientRepositoryInfract.save(ingredient);
    }

   
}
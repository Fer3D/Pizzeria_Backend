
package com.example.demo.application.ingredientApplication;

import java.util.UUID;

import com.example.demo.core.ApplicationBase;
import com.example.demo.domain.ingredientDomain.Ingredient;
import com.example.demo.domain.ingredientDomain.IngredientRepository;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class IngredientApplicationImpl implements IngredientApplication {

    private  IngredientRepository ingredientRepository; 
    private  ModelMapper modelMapper;

    @Autowired
    private IngredientApplicationImpl (final  IngredientRepository ingredientRepository,final ModelMapper modelMapper){

        this.ingredientRepository =ingredientRepository;
        this.modelMapper =modelMapper;
    }

    @Override
    public Mono<IngredientDTO> add(CreateOrUpdateIngredientDTO dto) {
        Ingredient ingredient = modelMapper.map(dto, Ingredient.class);
        ingredient.setId(UUID.randomUUID());
        ingredient.setThisNew(true);
        
        return this.ingredientRepository.add(ingredient).flatMap( monoIngredient -> {
            Mono.just(this.modelMapper.map(monoIngredient, IngredientDTO.class));
        });
    }
   
}








    
    
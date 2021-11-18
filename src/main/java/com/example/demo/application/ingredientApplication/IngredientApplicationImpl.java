package com.example.demo.application.ingredientApplication;

import java.util.UUID;

import com.example.demo.IngredientDTO.CreateOrUpdateIngredientDTO;
import com.example.demo.IngredientDTO.IngredientDTO;

import com.example.demo.domain.ingredientDomain.Ingredient;
import com.example.demo.infraestructure.ingredientinfraestructure.IngredientRepository;

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
    private Logger logger;

    @Override
    public Mono<IngredientDTO> add(CreateOrUpdateIngredientDTO dto) {
        Ingredient ingredient = modelMapper.map(dto, Ingredient.class);
        ingredient.setId(UUID.randomUUID());
        //ingredient.setThisNew(true);
        //ingredient.validate("name", ingredient.getName(), (name) -> this.ingredientRepository.exists(name));

        //El método flatMap le permite reemplazar cada valor de un flujo con otro flujo y luego une todos los flujos generados en un solo flujo
        return this.ingredientRepository.add(ingredient).flatMap( monoIngredient -> {
            logger.info(this.serializeObject(monoIngredient, "added"));
            return Mono.just(this.modelMapper.map(monoIngredient, IngredientDTO.class));
        });
    }

   
    }
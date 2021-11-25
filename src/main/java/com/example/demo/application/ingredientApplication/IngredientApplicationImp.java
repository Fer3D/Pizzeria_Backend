package com.example.demo.application.ingredientApplication;

import java.util.UUID;

import com.example.demo.core.ApplicationBase;
import com.example.demo.domain.ingredientDomain.Ingredient;
import com.example.demo.domain.ingredientDomain.IngredientWriteRepository;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class IngredientApplicationImp extends ApplicationBase<Ingredient, UUID> implements IngredientApplication {

    private final IngredientWriteRepository ingredientWriteRepository;
    private final ModelMapper modelMapper;
    private final Logger logger;

    @Autowired
    public IngredientApplicationImp(final IngredientWriteRepository ingredientWriteRepository,
             final ModelMapper modelMapper,
            final Logger logger) {

        super((id) -> ingredientWriteRepository.findById(id));

        this.ingredientWriteRepository = ingredientWriteRepository;
        this.modelMapper = modelMapper;
        this.logger = logger;
    }

    @Override
    public Mono<IngredientDTO> add(CreateOrUpdateIngredientDTO dto) {

        Ingredient ingredient = modelMapper.map(dto, Ingredient.class);
        ingredient.setId(UUID.randomUUID());
        ingredient.setThisNew(true);
        ingredient.validate("name", ingredient.getName(), (name) -> this.ingredientWriteRepository.exists(name));

        return this.ingredientWriteRepository.add(ingredient).flatMap( monoIngredient -> {
            logger.info(this.serializeObject(monoIngredient, "added"));
            return Mono.just(this.modelMapper.map(monoIngredient, IngredientDTO.class));
        });
    }

   
}

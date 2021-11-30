package com.example.demo.application;

import java.util.UUID;

import com.example.demo.application.ingredientApplication.CreateOrUpdateIngredientDTO;
import com.example.demo.application.ingredientApplication.IngredientDTO;
import com.example.demo.core.ApplicationBase;
import com.example.demo.domain.ingredientDomain.Ingredient;
import com.example.demo.domain.ingredientDomain.IngredientProjection;
import com.example.demo.domain.ingredientDomain.IngredientWriteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class IngredientApplicationImp extends ApplicationBase<Ingredient, UUID> implements IngredientApplication {

    private final IngredientWriteRepository ingredientWriteRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public IngredientApplicationImp(final IngredientWriteRepository ingredientWriteRepository,
            final ModelMapper modelMapper) {

        super((id) -> ingredientWriteRepository.findById(id));

        this.ingredientWriteRepository = ingredientWriteRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Mono<IngredientDTO> add(CreateOrUpdateIngredientDTO dto) {

        Ingredient ingredient = modelMapper.map(dto, Ingredient.class);
        ingredient.setId(UUID.randomUUID());
        ingredient.setThisNew(true);
        return ingredient.validate("name", ingredient.getName(), name -> this.ingredientWriteRepository.existsByField(name))
            .then(this.ingredientWriteRepository.add(ingredient)).flatMap(monoIngredient -> {
            return Mono.just(this.modelMapper.map(monoIngredient, IngredientDTO.class)); 
            });
        
    }

    @Override
    public Mono<IngredientDTO> get(UUID id) {
        return this.findById(id)
                .flatMap(dbingredient -> Mono.just(this.modelMapper.map(dbingredient, IngredientDTO.class)));
    }

    @Override
    public Mono<IngredientDTO> update(UUID id, CreateOrUpdateIngredientDTO dto) {
        return this.findById(id).flatMap(dbIngredient -> {
            if (dbIngredient.getName().equals(dto.getName())) {
                this.modelMapper.map(dto, dbIngredient);
                dbIngredient.validate();

                return this.ingredientWriteRepository.update(dbIngredient)
                        .flatMap(ingredient -> Mono.just(this.modelMapper.map(ingredient, IngredientDTO.class)));
            } else {
                this.modelMapper.map(dto, dbIngredient);
                dbIngredient.validate("name", dbIngredient.getName(),
                        (name) -> this.ingredientWriteRepository.existsByField(name));
                return this.ingredientWriteRepository.update(dbIngredient).flatMap(ingredient -> {
                    return Mono.just(this.modelMapper.map(ingredient, IngredientDTO.class));
                });
            }
        });
    }

    public Mono<Void> delete(UUID id) {
        return this.findById(id).flatMap(ingredient -> this.ingredientWriteRepository.delete(ingredient));
    }

    @Override
    public Flux<IngredientProjection> getAll(String name, int page, int size) {
        return this.ingredientWriteRepository.getAll(name, page, size);
    }

}

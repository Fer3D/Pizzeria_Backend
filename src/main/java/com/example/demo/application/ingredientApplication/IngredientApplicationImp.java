package com.example.demo.application.ingredientApplication;

import java.util.UUID;

import com.example.demo.core.ApplicationBase;
import com.example.demo.domain.ingredientDomain.Ingredient;
import com.example.demo.domain.ingredientDomain.IngredientWriteRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        //ingredient.validate("name", ingredient.getName(), (name) -> this.ingredientWriteRepository.exists(name));

        return this.ingredientWriteRepository.add(ingredient).flatMap( monoIngredient -> 
            Mono.just(this.modelMapper.map(monoIngredient, IngredientDTO.class))
        );
    }

    @Override
    public Mono<IngredientDTO> get(UUID id) {
        return this.findById(id).flatMap( dbingredient -> Mono.just(this.modelMapper.map(dbingredient, IngredientDTO.class)));
    }
    
    @Override
    public Mono <IngredientDTO> update(UUID id, CreateOrUpdateIngredientDTO dto){
        return this.findById(id).flatMap( dbIngredient -> {
            if(dbIngredient.getName().equals(dto.getName())){
                this.modelMapper.map(dto, dbIngredient);
                return this.ingredientWriteRepository.update(dbIngredient).flatMap(ingredient -> Mono.just(this.modelMapper.map(ingredient, IngredientDTO.class)));
            } else{
                this.modelMapper.map(dto, dbIngredient);
                
                return this.ingredientWriteRepository.update(dbIngredient).flatMap(ingredient -> {
                    return Mono.just(this.modelMapper.map(ingredient, IngredientDTO.class));
                });
            }   
        });
    }
}

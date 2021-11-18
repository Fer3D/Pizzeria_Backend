
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

    public  IngredientRepository ingredientRepository; //poner en private
    private  ModelMapper modelMapper;
    private Logger logger;

    @Override
    public Mono<IngredientDTO> add(CreateOrUpdateIngredientDTO dto) {
        Ingredient ingredient = modelMapper.map(dto, Ingredient.class);
        ingredient.setId(UUID.randomUUID());
        ingredient.setThisNew(true);
        ingredient.validate("name", ingredient.getName(), (name) -> this.ingredientRepository.exists(name));

        return this.ingredientRepository.add(ingredient).flatMap( monoIngredient -> {
            logger.info(this.serializeObject(monoIngredient, "added"));
            return Mono.just(this.modelMapper.map(monoIngredient, IngredientDTO.class));
        });
    }
    }









    
    /*
    @Override
    public Mono<IngredientDTO> get(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Mono<IngredientDTO> update(UUID id, CreateOrUpdateIngredientDTO dto) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Mono<IngredientDTO> delete(UUID id) {
        // TODO Auto-generated method stub
        return null;
    }
/*
    @Autowired
    public IngredientApplicationImpl(final IngredientRepository ingredientWriteRepository,
            final IngredientRepository ingredientReadRepository, final ModelMapper modelMapper,
            final Logger logger) {

        super((id) -> ingredientRepository.findById(id));

        this.ingredientRepository = ingredienRepository;
        this.ingredientRepository = ingredientRepository;
        this.modelMapper = modelMapper;
        this.logger = logger;
    }

    @Override
    public Mono<IngredientDTO> add(CreateOrUpdateIngredientDTO dto) {

        Ingredient ingredient = modelMapper.map(dto, Ingredient.class);
        ingredient.setId(UUID.randomUUID());
        ingredient.setThisNew(true);
        ingredient.validate("name", ingredient.getName(), (name) -> this.ingredientWriteRepository.exists(name));

        return this.ingredientRepository.add(ingredient).flatMap( monoIngredient -> {
            logger.info(this.serializeObject(monoIngredient, "added"));
            return Mono.just(this.modelMapper.map(monoIngredient, IngredientDTO.class));
        });
    }

    @Override
    public Mono<IngredientDTO> get(UUID id) {

        return this.findById(id).flatMap( dbingredient -> Mono.just(this.modelMapper.map(dbingredient, IngredientDTO.class)));
    }

    @Override
    public Mono<IngredientDTO> update(UUID id, CreateOrUpdateIngredientDTO dto) {

        return this.findById(id).flatMap( dbIngredient -> {
            if(dbIngredient.getName().equals(dto.getName())){
                this.modelMapper.map(dto, dbIngredient);
                dbIngredient.validate();
                return this.ingredientRepository.update(dbIngredient).flatMap(ingredient -> Mono.just(this.modelMapper.map(ingredient, IngredientDTO.class)));
            } else{
                this.modelMapper.map(dto, dbIngredient);
                dbIngredient.validate("name", dbIngredient.getName(), (name) -> this.ingredientWriteRepository.exists(name));
                return this.ingredientRepository.update(dbIngredient).flatMap(ingredient -> {
                    logger.info(this.serializeObject(dbIngredient, "updated"));
                    return Mono.just(this.modelMapper.map(ingredient, IngredientDTO.class));
                });
            }   
        });
    }

    @Override
    public Mono<IngredientDTO> delete(UUID id) {
        
        return this.findById(id).flatMap(ingredient -> {
            logger.info(this.serializeObject(ingredient, "deleted")); 
            return this.ingredientRepository.delete(ingredient).then(Mono.just(this.modelMapper.map(ingredient, IngredientDTO.class)));}
        );
    }
//se han creado los metodos para que reconozco serializeObject y findby
    private String serializeObject(IngredientDTO ingredient, String string) {
        return null;
    }

    private Mono<IngredientDTO> findById(UUID id) {
        return null;
    }

   
}*/


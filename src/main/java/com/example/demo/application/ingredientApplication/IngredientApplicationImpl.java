
package com.example.demo.application.ingredientApplication;


import com.example.demo.domain.ingredientDomain.Ingredient;
import com.example.demo.domain.ingredientDomain.IngredientWriteRepository;
import org.modelmapper.ModelMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class IngredientApplicationImpl{ 

    private final IngredientWriteRepository ingredientWriteRepository;
    private final ModelMapper modelMapper;
  

    @Autowired
    public IngredientApplicationImpl (final IngredientWriteRepository ingredientWriteRepository, 
    final ModelMapper modelMapper){
        this.ingredientWriteRepository = ingredientWriteRepository;
        this.modelMapper = modelMapper;
    }

    //@Override
    public Mono<IngredientDTO> add(CreateOrUpdateIngredientDTO createorupdateDto) {

        Ingredient ingredient = modelMapper.map(createorupdateDto, Ingredient.class);
        return this.ingredientWriteRepository.add(ingredient).flatMap(entity -> Mono.just(this.modelMapper.map(entity, IngredientDTO.class)));
        
    }
   
}

        
  









    
    
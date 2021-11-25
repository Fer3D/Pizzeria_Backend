package com.example.demo.controller.ingredientcontroller;


import javax.validation.Valid;

import com.example.demo.application.ingredientApplication.CreateOrUpdateIngredientDTO;

import com.example.demo.application.ingredientApplication.IngredientApplicationImpl;
import com.example.demo.application.ingredientApplication.IngredientDTO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/v1/ingredients")
public class IngredientController{
    
    private final IngredientApplicationImpl ingredientApplicationImpl;

    @Autowired
    public IngredientController(final IngredientApplicationImpl ingredientApplicationImpl){
        this.ingredientApplicationImpl = ingredientApplicationImpl;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<IngredientDTO> create(@Valid @RequestBody CreateOrUpdateIngredientDTO dto){
        Mono<IngredientDTO> ingredientDTO = this.ingredientApplicationImpl.add(dto);

        return ingredientDTO;
    }

}

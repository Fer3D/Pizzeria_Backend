package com.example.demo.controller.ingredientcontroller;


import java.util.UUID;

import javax.validation.Valid;

import com.example.demo.application.ingredientApplication.CreateOrUpdateIngredientDTO;
import com.example.demo.application.ingredientApplication.IngredientApplication;
import com.example.demo.application.ingredientApplication.IngredientDTO;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/v1/ingredients")
public class IngredientController{
    
    private final IngredientApplication ingredientApplication;
    private ModelMapper modelMapper;

    @Autowired
    public IngredientController(final IngredientApplication ingredientApplication){
        this.ingredientApplication = ingredientApplication;
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<IngredientDTO> create(@Valid @RequestBody CreateOrUpdateIngredientDTO dto){
        Mono<IngredientDTO> ingredientDTO = this.ingredientApplication.add(dto);

        return ingredientDTO;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE,  path = "/{id}")
    public Mono<IngredientDTO>get(@Valid @PathVariable UUID id) {
        return this.ingredientApplication.get(id);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, path = "/{id}")
    public Mono<IngredientDTO> update(@PathVariable UUID id, @Valid @RequestBody CreateOrUpdateIngredientDTO dto) {
        return this.ingredientApplication.update(id, dto);
    }

    @DeleteMapping(path = "/{id}")
    public Mono<Void>delete(@PathVariable UUID id) {
        return this.ingredientApplication.delete(id);
    }
           
}

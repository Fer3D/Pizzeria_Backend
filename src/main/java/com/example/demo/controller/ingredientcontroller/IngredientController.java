package com.example.demo.controller.ingredientcontroller;


import java.util.UUID;

import javax.validation.Valid;

import com.example.demo.application.ingredientApplication.CreateOrUpdateIngredientDTO;
import com.example.demo.application.ingredientApplication.IngredientApplication;
import com.example.demo.application.ingredientApplication.IngredientDTO;
import com.example.demo.domain.ingredientDomain.IngredientProjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/v1/ingredients")
public class IngredientController{
    
    private final IngredientApplication ingredientApplication;
   

    @Autowired
    public IngredientController(IngredientApplication ingredientApplication){
        this.ingredientApplication = ingredientApplication;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<IngredientDTO> add(@Valid @RequestBody CreateOrUpdateIngredientDTO dto){
        Mono<IngredientDTO> ingredientDTO = this.ingredientApplication.add(dto);
            return ingredientDTO;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<IngredientDTO>get(@Valid @PathVariable UUID id) {
        return this.ingredientApplication.get(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<IngredientDTO> update(@PathVariable UUID id, @Valid @RequestBody CreateOrUpdateIngredientDTO dto) {
        return this.ingredientApplication.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void>delete(@PathVariable UUID id) {
        return this.ingredientApplication.delete(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<IngredientProjection> getAll(
        @RequestParam(required = false) String name,
        @RequestParam(defaultValue = "10") Integer limit,
		@RequestParam(defaultValue = "0") Integer offset) {
		return this.ingredientApplication.getAll(name, limit, offset);
    
    }
           
}

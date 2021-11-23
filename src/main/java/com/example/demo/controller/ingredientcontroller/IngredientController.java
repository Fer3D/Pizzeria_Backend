package com.example.demo.controller.ingredientcontroller;

import com.example.demo.domain.ingredientDomain.Ingredient;
import com.example.demo.domain.ingredientDomain.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {
    private final IngredientRepository ingredientRepository;
    @Autowired
    public IngredientController(final IngredientRepository ingredientRepository){
        this.ingredientRepository = ingredientRepository;
    }
    @PostMapping
    Mono<ResponseEntity<Ingredient>> addIngredient(@RequestBody Ingredient ingredientAdd) {
        return ingredientRepository.save(ingredientAdd)
        .map(ingredient -> new ResponseEntity<>(ingredient, HttpStatus.CREATED)
        );
    }    
}

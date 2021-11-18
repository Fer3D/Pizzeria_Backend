package com.example.demo.controller.ingredientcontroller;



import java.util.UUID;

import com.example.demo.domain.ingredientDomain.Ingredient;
import com.example.demo.infraestructure.ingredientinfraestructure.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    
    @GetMapping("/{id}")
    Mono<ResponseEntity<Ingredient>> getIngredient(@PathVariable UUID id) {                
        return ingredientRepository.findById(id)
        .switchIfEmpty(
          Mono.error(new RuntimeException())
        )
        .map(ingredient -> new ResponseEntity<>(ingredient, HttpStatus.OK));
        
    }

    @PostMapping
    Mono<ResponseEntity<Ingredient>> addIngredient(@RequestBody Ingredient ingredientAdd) {
        return ingredientRepository.save(ingredientAdd)
        .map(ingredient -> new ResponseEntity<>(ingredient, HttpStatus.CREATED)
        );
    }

    @PutMapping ("/ingredient/{id}")
    Mono<ResponseEntity<Ingredient>> updateIngredient(@PathVariable UUID ingredientID, @RequestBody Ingredient newIngredientData) {

    return ingredientRepository.findById(ingredientID)
            .switchIfEmpty(Mono.error(new Exception("Student with ID " + ingredientID + " not found")))
            .flatMap(foundIngredient -> {
                foundIngredient.setName(newIngredientData.getName());

                return ingredientRepository.save(foundIngredient).map(ingredient -> {
                    return new ResponseEntity<>(ingredient, HttpStatus.ACCEPTED);
                });
            });

}

    @DeleteMapping("/{ingredientID}")
    Mono<ResponseEntity<Ingredient>> deleteIngredient(@PathVariable UUID id) {
        return ingredientRepository.findById(id).switchIfEmpty(
            Mono.error(new RuntimeException())
          )
        .map(deletedIngredient -> new ResponseEntity<>(deletedIngredient, HttpStatus.CREATED)
        );
    }

    
}

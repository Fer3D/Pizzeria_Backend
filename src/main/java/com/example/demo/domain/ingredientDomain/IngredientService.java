package com.example.demo.domain.ingredientDomain;
//import java.util.UUID;

import com.example.demo.IngredientDTO.IngredientDTO;


public class IngredientService {
    
    public static Ingredient add(Ingredient dto){
        Ingredient ingredient = new Ingredient();
        ingredient.name = dto.name;
        ingredient.price = dto.price;
        //ingredient.id = UUID.randomUUID();
        return ingredient; 
    }
    
    public static IngredientDTO addDTO(Ingredient ingredient) {
        IngredientDTO ingredientDTO = new IngredientDTO();
        //ingredientDTO.id = ingredient.id;
        ingredientDTO.name = ingredient.name;
        ingredientDTO.price = ingredient.price;
        return ingredientDTO; 
    }
}

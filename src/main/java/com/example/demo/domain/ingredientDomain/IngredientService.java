package com.bootcampProject.pizzeriaBackend.Domain.IngredientDomain;
import java.util.UUID;
import com.bootcampProject.pizzeriaBackend.IngredientDto.IngredientDTO;

public class IngredientService {
    
    public static Ingredient add(Ingredient dto){
        Ingredient ingredient = new Ingredient();
        ingredient.name = dto.name;
        ingredient.price = dto.price;
        ingredient.id = UUID.randomUUID();
        return ingredient; 
    }
    
    public static IngredientDTO addDTO(Ingredient ingredient) {
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.id = ingredient.id;
        ingredientDTO.name = ingredient.name;
        ingredientDTO.price = ingredient.price;
        return ingredientDTO; 
    }
}

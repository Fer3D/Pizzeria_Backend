package com.bootcampProject.pizzeriaBackend.domain;

import java.util.UUID;

//import com.bootcampProject.pizzeriaBackend.domain.Ingredients;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientsRep extends ReactiveCrudRepository<Ingredients, UUID> {
    
}
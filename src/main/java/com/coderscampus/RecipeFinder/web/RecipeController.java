package com.coderscampus.RecipeFinder.web;

import com.coderscampus.RecipeFinder.domain.Recipe;
import com.coderscampus.RecipeFinder.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/all")
    public ResponseEntity<Collection<Recipe>> getAllRecipes() {
        return ResponseEntity.ok(recipeService.getAllRecipes());
    }

    @GetMapping("/gluten-free")
    public ResponseEntity<Collection<Recipe>> getGlutenFreeRecipes() {
        return ResponseEntity.ok(recipeService.getGlutenFreeRecipes());
    }

    @GetMapping("/vegan")
    public ResponseEntity<Collection<Recipe>> getVeganRecipes() {
        return ResponseEntity.ok(recipeService.getVeganRecipes());
    }

    @GetMapping("/vegan-and-gluten-free")
    public ResponseEntity<Collection<Recipe>> getVeganAndGlutenFreeRecipes() {
        return ResponseEntity.ok(recipeService.getVeganAndGlutenFreeRecipes());
    }

    @GetMapping("/vegetarian")
    public ResponseEntity<Collection<Recipe>> getVegetarianRecipes() {
        return ResponseEntity.ok(recipeService.getVegetarianRecipes());
    }
}


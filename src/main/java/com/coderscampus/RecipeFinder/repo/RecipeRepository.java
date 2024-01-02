package com.coderscampus.RecipeFinder.repo;

import com.coderscampus.RecipeFinder.domain.Recipe;
import com.coderscampus.RecipeFinder.service.FileService;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class RecipeRepository {

    private Map<Integer, Recipe> recipeMap = new HashMap<>();
    private final FileService fileService;

    public RecipeRepository(FileService fileService) {
        this.fileService = fileService;
        loadRecipes();
    }

    private void loadRecipes() {
        Map<Integer, Recipe> recipes = fileService.readRecipeFile();
        recipeMap.putAll(recipes);
    }

    public Collection<Recipe> getAllRecipes() {
        return recipeMap.values();
    }

    public Optional<Recipe> getRecipeById(Integer id) {
        return Optional.ofNullable(recipeMap.get(id));
    }

    public void addOrUpdateRecipe(Recipe recipe) {
        recipeMap.put(recipe.getId(), recipe);
    }

    public void deleteRecipe(Integer id) {
        recipeMap.remove(id);
    }
}


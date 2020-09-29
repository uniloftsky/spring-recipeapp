package uniloft.springframework.springrecipeapp.services;

import uniloft.springframework.springrecipeapp.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    Recipe saveRecipe(Recipe recipe);
}

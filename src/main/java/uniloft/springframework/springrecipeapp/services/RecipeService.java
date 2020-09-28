package uniloft.springframework.springrecipeapp.services;

import uniloft.springframework.springrecipeapp.model.Category;
import uniloft.springframework.springrecipeapp.model.Ingredient;
import uniloft.springframework.springrecipeapp.model.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long id);
    Set<Category> getRecipeCategories(Long id);
    Set<Ingredient> getRecipeIngredients(Long id);
}

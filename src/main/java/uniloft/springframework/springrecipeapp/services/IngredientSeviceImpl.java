package uniloft.springframework.springrecipeapp.services;

import org.springframework.stereotype.Service;
import uniloft.springframework.springrecipeapp.model.Ingredient;
import uniloft.springframework.springrecipeapp.model.Recipe;
import uniloft.springframework.springrecipeapp.repositories.RecipeRepository;

import java.util.Optional;

@Service
public class IngredientSeviceImpl implements IngredientSevice {

    private final RecipeRepository recipeRepository;

    public IngredientSeviceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Ingredient findByRecipeIdAndId(Long id_recipe, Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id_recipe);
        if(recipeOptional.isEmpty()) {
            throw new RuntimeException("Expected recipe is not found!");
        }

        Recipe recipe = recipeOptional.get();

        Optional<Ingredient> ingredientOptional = recipe.getIngredients().stream().filter(ingredient -> ingredient.getId().equals(id)).findFirst();
        if(ingredientOptional.isEmpty()) {
            throw new RuntimeException("Expected ingredient not found!");
        }

        return ingredientOptional.get();
    }
}

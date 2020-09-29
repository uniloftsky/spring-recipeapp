package uniloft.springframework.springrecipeapp.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import uniloft.springframework.springrecipeapp.model.Category;
import uniloft.springframework.springrecipeapp.model.Ingredient;
import uniloft.springframework.springrecipeapp.model.Recipe;
import uniloft.springframework.springrecipeapp.repositories.RecipeRepository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("I`m in the service");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Recipe findById(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if(recipeOptional.isEmpty()) {
            throw new RuntimeException("Expected recipe not found");
        }
        return recipeOptional.get();
    }

    @Override
    public Set<Category> getRecipeCategories(Long id) {
        Set<Category> categories = new HashSet<>();
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if(recipeOptional.isEmpty()) {
            throw new RuntimeException("Expected recipe not found");
        }
        recipeOptional.get().getCategories().iterator().forEachRemaining(categories::add);
        return categories;
    }

    @Override
    public Set<Ingredient> getRecipeIngredients(Long id) {
        Set<Ingredient> ingredients = new HashSet<>();
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if(recipeOptional.isEmpty()) {
            throw new RuntimeException("Expected recipe not found");
        }
        recipeOptional.get().getIngredients().iterator().forEachRemaining(ingredients::add);
        return ingredients;
    }
}

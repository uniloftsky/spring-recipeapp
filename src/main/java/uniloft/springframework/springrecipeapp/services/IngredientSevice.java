package uniloft.springframework.springrecipeapp.services;

import uniloft.springframework.springrecipeapp.model.Ingredient;

public interface IngredientSevice {

    Ingredient findByRecipeIdAndId(Long id_recipe, Long id);

}

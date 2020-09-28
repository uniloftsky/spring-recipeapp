package uniloft.springframework.springrecipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uniloft.springframework.springrecipeapp.services.RecipeService;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipe/show/{id_recipe}")
    public String showById(@PathVariable String id_recipe, Model model) {
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id_recipe)));
        model.addAttribute("recipe_categories", recipeService.getRecipeCategories(Long.valueOf(id_recipe)));
        model.addAttribute("recipe_ingredients", recipeService.getRecipeIngredients(Long.valueOf(id_recipe)));
        return "recipe/show";
    }
}

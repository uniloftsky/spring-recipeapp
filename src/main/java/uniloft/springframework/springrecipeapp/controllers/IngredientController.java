package uniloft.springframework.springrecipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uniloft.springframework.springrecipeapp.services.IngredientSevice;
import uniloft.springframework.springrecipeapp.services.RecipeService;

@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientSevice ingredientSevice;

    public IngredientController(RecipeService recipeService, IngredientSevice ingredientSevice) {
        this.recipeService = recipeService;
        this.ingredientSevice = ingredientSevice;
    }

    @GetMapping
    @RequestMapping("recipe/{id}/ingredients")
    public String listOfIngredients(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
        return "recipe/ingredient/list";
    }

    @GetMapping
    @RequestMapping("recipe/{id_recipe}/ingredient/{id}/show")
    public String showIngredient(@PathVariable String id_recipe, @PathVariable String id, Model model) {
        model.addAttribute("ingredient", ingredientSevice.findByRecipeIdAndId(Long.valueOf(id_recipe), Long.valueOf(id)));
        return "recipe/ingredient/show";
    }

}

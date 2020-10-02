package uniloft.springframework.springrecipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import uniloft.springframework.springrecipeapp.model.Ingredient;
import uniloft.springframework.springrecipeapp.model.Recipe;
import uniloft.springframework.springrecipeapp.model.UnitOfMeasure;
import uniloft.springframework.springrecipeapp.services.IngredientSevice;
import uniloft.springframework.springrecipeapp.services.RecipeService;
import uniloft.springframework.springrecipeapp.services.UomService;

@Controller
public class IngredientController {

    private final RecipeService recipeService;
    private final IngredientSevice ingredientSevice;
    private final UomService uomService;

    public IngredientController(RecipeService recipeService, IngredientSevice ingredientSevice, UomService uomService) {
        this.recipeService = recipeService;
        this.ingredientSevice = ingredientSevice;
        this.uomService = uomService;
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

    @GetMapping
    @RequestMapping("recipe/{id_recipe}/ingredient/{id}/update")
    public String updateIngredient(@PathVariable String id_recipe, @PathVariable String id, Model model) {
        model.addAttribute("uoms", uomService.getUoms());
        model.addAttribute("ingredient", ingredientSevice.findByRecipeIdAndId(Long.valueOf(id_recipe), Long.valueOf(id)));
        return "recipe/ingredient/ingredientform";
    }

    @GetMapping
    @RequestMapping("recipe/{id_recipe}/ingredient/new")
    public String newIngredient(@PathVariable String id_recipe, Model model) {
        Recipe recipe = recipeService.findById(Long.valueOf(id_recipe));
        Ingredient ingredient = new Ingredient();
        ingredient.setRecipe(recipe);
        ingredient.getRecipe().setId(Long.valueOf(id_recipe));
        ingredient.setUof(new UnitOfMeasure());
        model.addAttribute("ingredient", ingredient);
        model.addAttribute("uoms", uomService.getUoms());
        return "recipe/ingredient/ingredientform";
    }

    @PostMapping
    @RequestMapping("recipe/{id_recipe}/ingredient/")
    public String saveIngredient(@ModelAttribute Ingredient ingredient) {
        Ingredient savedIngredient = ingredientSevice.saveIngredient(ingredient);
        return "redirect:/recipe/" + savedIngredient.getRecipe().getId() + "/ingredient/" + savedIngredient.getId() + "/show";
    }

}

package uniloft.springframework.springrecipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uniloft.springframework.springrecipeapp.commands.RecipeCommand;
import uniloft.springframework.springrecipeapp.model.Recipe;
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
        return "recipe/show";
    }

    @RequestMapping("recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeCommand());
        return "recipe/recipeform";
    }

    @PostMapping
    @RequestMapping("recipe")
    public String saveOrUpdate(@ModelAttribute Recipe recipe) {
        Recipe savedRecipe = recipeService.saveRecipe(recipe);
        return "redirect:/recipe/show/" + savedRecipe.getId();
    }

}

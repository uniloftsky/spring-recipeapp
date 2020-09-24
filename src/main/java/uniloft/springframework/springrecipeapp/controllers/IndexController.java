package uniloft.springframework.springrecipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import uniloft.springframework.springrecipeapp.services.RecipeService;

@Slf4j
@Controller
public class IndexController {

    private RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/", "", "index", "index.html", "privet"})
    public String getIndexPage(Model model) {
        log.debug("Controller is working");
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }

}

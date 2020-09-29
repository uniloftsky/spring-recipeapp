package uniloft.springframework.springrecipeapp.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uniloft.springframework.springrecipeapp.model.Category;
import uniloft.springframework.springrecipeapp.model.Difficulty;
import uniloft.springframework.springrecipeapp.model.Ingredient;
import uniloft.springframework.springrecipeapp.model.Notes;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {

    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;
    private Set<Ingredient> ingredients = new HashSet<>();
    private Set<Category> categories = new HashSet<>();
    private Notes notes;

}

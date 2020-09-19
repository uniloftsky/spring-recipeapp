package uniloft.springframework.springrecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.springrecipeapp.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}

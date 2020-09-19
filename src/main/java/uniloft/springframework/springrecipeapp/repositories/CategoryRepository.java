package uniloft.springframework.springrecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.springrecipeapp.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}

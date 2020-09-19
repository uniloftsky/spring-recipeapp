package uniloft.springframework.springrecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.springrecipeapp.model.UnitOfMeasure;

public interface UofRepository extends CrudRepository<UnitOfMeasure, Long> {
}

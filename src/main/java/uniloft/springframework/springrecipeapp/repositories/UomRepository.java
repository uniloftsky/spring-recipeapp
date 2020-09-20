package uniloft.springframework.springrecipeapp.repositories;

import org.springframework.data.repository.CrudRepository;
import uniloft.springframework.springrecipeapp.model.UnitOfMeasure;

import java.util.Optional;

public interface UomRepository extends CrudRepository<UnitOfMeasure, Long> {

    Optional<UnitOfMeasure> findByUom(String uom);

}

package tn.med.chapter7.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.med.chapter7.models.UnitOfMeasure;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {
    Optional<UnitOfMeasure> findByUom(String uom);
}

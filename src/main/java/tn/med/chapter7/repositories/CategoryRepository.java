package tn.med.chapter7.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.med.chapter7.models.Category;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {
    Optional<Category> findByCategoryName(String categoryName);
}

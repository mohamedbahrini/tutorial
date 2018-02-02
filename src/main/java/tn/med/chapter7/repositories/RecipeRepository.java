package tn.med.chapter7.repositories;

import org.springframework.data.repository.CrudRepository;

import tn.med.chapter7.models.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}

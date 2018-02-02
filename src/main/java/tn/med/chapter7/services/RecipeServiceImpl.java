package tn.med.chapter7.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.med.chapter7.models.Recipe;
import tn.med.chapter7.repositories.RecipeRepository;

import java.util.List;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {
    private RecipeRepository recipeRepository;

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public List<Recipe> getRecipes() {
        log.error("service get recipes");
        return (List<Recipe>) recipeRepository.findAll();
    }
}

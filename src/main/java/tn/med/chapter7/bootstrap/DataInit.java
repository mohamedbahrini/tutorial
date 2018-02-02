package tn.med.chapter7.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import tn.med.chapter7.models.*;
import tn.med.chapter7.repositories.CategoryRepository;
import tn.med.chapter7.repositories.RecipeRepository;
import tn.med.chapter7.repositories.UnitOfMeasureRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataInit implements ApplicationListener<ContextRefreshedEvent> {
    private CategoryRepository categoryRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;
    private RecipeRepository recipeRepository;

    @Autowired
    public DataInit(CategoryRepository categoryRepository,
                    UnitOfMeasureRepository unitOfMeasureRepository,
                    RecipeRepository recipeRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional // to avoid lazy error
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Recipe recipe = new Recipe();
        Set<Category> categories = new HashSet<>();
        categories.add(categoryRepository.findByCategoryName("TUNISIAN").get());

        Set<Ingredient> ingredients = new HashSet<>();
        Ingredient ingredient1 = new Ingredient();
        ingredient1.setAmount(new BigDecimal(20));
        ingredient1.setDescription("Good ingredients");
        ingredient1.setUnitOfMeasure(unitOfMeasureRepository.findByUom("g").get());
        ingredient1.setRecipe(recipe);
        Ingredient ingredient2 = new Ingredient();
        ingredient2.setAmount(new BigDecimal(1));
        ingredient2.setDescription("too much");
        ingredient2.setUnitOfMeasure(unitOfMeasureRepository.findByUom("kg").get());
        ingredient2.setRecipe(recipe);
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);

        Notes notes = new Notes();
        notes.setRecipeNotes("Dont cook it too much !");

        recipe.setCategories(categories);
        recipe.setCookTime(30);
        recipe.setDescription("good meal");
        recipe.setIngredients(ingredients);
        recipe.setDifficulty(Difficulty.MODERATE);
        recipe.setDirections("Put everything together");
        recipe.setNotes(notes);
        recipe.setUrl("http://www.google.com");
        recipe.setSource("internet");
        recipe.setServings(4);
        recipe.setPrepTime(20);

        recipeRepository.save(recipe);
    }
}

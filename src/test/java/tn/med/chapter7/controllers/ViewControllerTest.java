package tn.med.chapter7.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import tn.med.chapter7.models.Recipe;
import tn.med.chapter7.services.RecipeService;

public class ViewControllerTest {
	@Mock
	private RecipeService recipeService;
	@Mock
	private Model model;
	
	ViewController viewController;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		viewController = new ViewController(recipeService);
	}
	
	@Test
	public void testMockMvc() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(viewController).build();
		mockMvc.perform(get("/"))
			   .andExpect(status().isOk())
			   .andExpect(view().name("index"));
	}
	
	@Test
	public void index() {
		List <Recipe> recipes = new ArrayList<Recipe>();
		recipes.add(new Recipe());
		recipes.add(new Recipe());
		when(recipeService.getRecipes()).thenReturn(recipes);
		
		assertEquals("index", viewController.index(model));
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute("recipes", recipeService.getRecipes());
	}
}

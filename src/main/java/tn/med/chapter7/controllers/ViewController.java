package tn.med.chapter7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tn.med.chapter7.services.RecipeService;

@Controller
public class ViewController {
	private RecipeService recipeService;

	@Autowired
	public ViewController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping({"/", "index"})
	public String index(Model model) {
		model.addAttribute("recipes", recipeService.getRecipes());
		return "index";
	}
}

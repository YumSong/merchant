package com.lames.merchant.service.newVersion;

import java.util.List;

import com.lames.merchant.model.Recipe;

public interface IRecipeService {
	public Recipe findByRecipeId(Recipe recipe);
	
	public List<Recipe> findAll(Integer shop_id);
	
	public Recipe saveRecipe(Recipe recipe);
	
	public Recipe modifyRecipe(Recipe recipe);
	
	public Recipe deleteByRecipeId(Recipe recipe);
}

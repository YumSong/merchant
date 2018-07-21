package com.lames.merchant.service.newVersion;

import java.util.List;

import com.lames.merchant.po.Recipe;

public interface IRecipeService {
	public Recipe findByRecipe(Recipe recipe);
	
	public List<Recipe> findAllByShopId(Recipe recipe);
	
	public Recipe saveRecipe(Recipe recipe);
	
	public Recipe modifyRecipe(Recipe recipe);
	
	public Recipe deleteByRecipeId(Recipe recipe);
}

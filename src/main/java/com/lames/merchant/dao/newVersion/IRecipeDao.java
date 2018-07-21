package com.lames.merchant.dao.newVersion;

import java.util.List;

import com.lames.merchant.po.Recipe;

public interface IRecipeDao {
	public Recipe findByRecipeId(Recipe recipe);
	
	public List<Recipe> findAllByShopId(Recipe recipe);
	
	public int saveRecipe(Recipe recipe);
	
	public int modifyRecipe(Recipe recipe);
	
	public int deleteByRecipeId(Recipe recipe);
}

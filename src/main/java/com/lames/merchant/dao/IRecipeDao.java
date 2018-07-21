package com.lames.merchant.dao;

import java.util.List;

import com.lames.merchant.model.Recipe;

public interface IRecipeDao {
	public Recipe find(Recipe recipe);
	
	public List<Recipe> findAll(Integer shopId);
	
	public Recipe insert(Recipe recipe);
	
	public Recipe modify(Recipe recipe);
	
	public Recipe delete(Recipe recipe);

	
}

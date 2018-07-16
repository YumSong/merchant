package com.lames.merchant.service;

import java.util.List;

import com.lames.merchant.model.Recipe;

public interface IRecipeService {
	public Recipe find(Recipe recipe);
	
	public List<Recipe> findAll(Integer shop_id);
	
	public Recipe insert(Recipe recipe);
	
	public Recipe modify(Recipe recipe);
	
	public Recipe delete(Recipe recipe);
}

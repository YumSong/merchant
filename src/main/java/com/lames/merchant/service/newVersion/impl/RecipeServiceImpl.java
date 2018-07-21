package com.lames.merchant.service.newVersion.impl;

import java.util.List;

import com.lames.merchant.dao.IRecipeDao;
import com.lames.merchant.dao.impl.RecipeDaoImpl;
import com.lames.merchant.model.Recipe;
import com.lames.merchant.service.IRecipeService;

public class RecipeServiceImpl implements IRecipeService {
	IRecipeDao dao = new RecipeDaoImpl();
	
	@Override
	public Recipe find(Recipe recipe) {
		return dao.find(recipe);
	}

	@Override
	public List<Recipe> findAll(Integer shop_id) {
		return dao.findAll(shop_id);
	}

	@Override
	public Recipe insert(Recipe recipe) {
		return dao.insert(recipe);
	}

	@Override
	public Recipe modify(Recipe recipe) {
		return dao.modify(recipe);
	}

	@Override
	public Recipe delete(Recipe recipe) {
		return dao.delete(recipe);
	}

}

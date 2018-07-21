package com.lames.merchant.service.newVersion.impl;

import java.util.List;

import com.lames.merchant.dao.newVersion.IRecipeDao;
import com.lames.merchant.dao.newVersion.impl.RecipeDaoImpl;
import com.lames.merchant.po.Recipe;
import com.lames.merchant.service.newVersion.IRecipeService;


public class RecipeServiceImpl implements IRecipeService {
	private IRecipeDao dao = new RecipeDaoImpl();

	@Override
	public Recipe findByRecipe(Recipe recipe) {
		return dao.findByRecipeId(recipe);
	}

	@Override
	public List<Recipe> findAllByShopId(Recipe recipe) {
		return dao.findAllByShopId(recipe);
	}

	@Override
	public Recipe saveRecipe(Recipe recipe) {
		dao.saveRecipe(recipe);
		if(recipe.getRecipeId() == null) {
			return null;
		}
		return recipe;
	}

	@Override
	public Recipe modifyRecipe(Recipe recipe) {
		int status = dao.modifyRecipe(recipe);
		if(status ==0) {
			return null;
		}
		return recipe;
	}

	@Override
	public Recipe deleteByRecipeId(Recipe recipe) {
		int status = dao.deleteByRecipeId(recipe);
		if(status == 0) {
			return null;
		}
		return recipe;
	}
	
}

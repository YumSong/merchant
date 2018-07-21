package com.lames.merchant.dao.newVersion;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lames.merchant.dao.newVersion.impl.RecipeDaoImpl;
import com.lames.merchant.po.Recipe;


public class IRecipeDaoTest {
	private IRecipeDao dao;
	
	@Before
	public void before() {
		dao = new RecipeDaoImpl();
	}

	@Test
	public void testFindByRecipeId() {
		Recipe recipe = new Recipe();
		recipe.setRecipeId(2);
		Recipe recipe1 = dao.findByRecipeId(recipe);
		Assert.assertNotNull(recipe1);
		System.out.println(recipe1);
		
	}

	@Test
	public void testFindAllByShopId() {
		Recipe recipe = new Recipe();
		recipe.setShopId(2);
		List<Recipe> recipes = dao.findAllByShopId(recipe);
		Assert.assertNotNull(recipes);
		System.out.println(recipes);
	}

	@Test
	public void testSaveRecipe() {
		Recipe recipe = new Recipe();
		recipe.setRecipeName("fafafafaf");
		recipe.setRecipePic("/imgs/recipePic.jpg");
		recipe.setRecipeDetail("Gook milk");
		recipe.setRecipePrice(10.0);
		recipe.setShopId(2);
		Assert.assertEquals(dao.saveRecipe(recipe), 1);
	}

	@Test
	public void testModifyRecipe() {
		Recipe recipe = new Recipe();
		recipe.setRecipeId(2);
		recipe.setRecipeName("Milk");
		recipe.setRecipePic("/imgs/recipePic.jpg");
		recipe.setRecipeDetail("Gook drink");
		recipe.setRecipePrice(20.0);
		recipe.setShopId(3);
		Assert.assertEquals(dao.modifyRecipe(recipe), 1);
	}

	@Test
	public void testDeleteByRecipeId() {
		Recipe recipe = new Recipe();
		recipe.setRecipeId(5);
		Assert.assertEquals(dao.deleteByRecipeId(recipe), 1);
	}

}

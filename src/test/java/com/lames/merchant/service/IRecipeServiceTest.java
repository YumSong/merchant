package com.lames.merchant.service;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lames.merchant.model.Recipe;
import com.lames.merchant.service.impl.RecipeServiceImpl;

public class IRecipeServiceTest {
	private IRecipeService service = new RecipeServiceImpl();
	private Recipe recipe;
	@Before
	public void before() {
		recipe = new Recipe();
	}
	
	@Test
	public void testFind() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		Assert.assertEquals(service.findAll(1374).isEmpty(), false);
	}

	@Test
	public void testInsert() {
		recipe.setRe_name("扣锅肉");
		recipe.setRe_pic("http://locahost/kouGuoRou.png");
		recipe.setDetail("好吃，甜而不腻");
		recipe.setPrice(24.0);
		recipe.setShop_id(2012);
		Assert.assertNotNull(service.insert(recipe));
	}

	@Test
	public void testModify() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

}

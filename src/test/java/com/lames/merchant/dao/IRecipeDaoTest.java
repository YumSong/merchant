package com.lames.merchant.dao;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lames.merchant.dao.impl.RecipeDaoImpl;
import com.lames.merchant.model.Recipe;

public class IRecipeDaoTest {
	private Recipe recipe;
	private IRecipeDao dao  = new RecipeDaoImpl();
	
	@Before
	public void before() {
		recipe = new Recipe();
	}

	@Test
	public void testFind() {
		recipe.setRe_id(19);;
		Assert.assertNotNull(dao.find(recipe));
		System.out.println(dao.find(recipe));
	}

	@Test
	public void testFindAll() {
		Assert.assertEquals(dao.findAll().isEmpty(), false);
	}

	@Test
	public void testInsert() {
		recipe.setRe_name("红烧肉");
		recipe.setRe_pic("http://locahost/hongShaoRou.png");
		recipe.setDetail("好吃，油而不腻");
		recipe.setPrice(25.0);
		recipe.setShop_id(2012);
		Assert.assertNotNull(dao.insert(recipe));
	}

	@Test
	public void testModify() {
		recipe.setRe_name("梅花肉");
		recipe.setRe_pic("http://locahost/meiHuaRou.png");
		recipe.setDetail("梅花香辣味，是你的最爱");
		recipe.setPrice(30.5);
		recipe.setShop_id(2012);
		recipe.setRe_id(18);
		Assert.assertNotNull(dao.modify(recipe));
	}

	@Test
	public void testDelete() {
		recipe.setRe_id(20);
		Assert.assertNotNull(dao.delete(recipe));
	}

}

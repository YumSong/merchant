package com.lames.merchant.dao;

import static org.junit.Assert.fail;

import java.sql.Date;
import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lames.merchant.dao.impl.ShopDaoImpl;
import com.lames.merchant.model.Shop;

public class IShopDaoTest {
	private IShopDao dao = new ShopDaoImpl();
	private Shop shop;
	
	@Before
	public void before() {
		shop = new Shop();
	}
	
	@Test
	public void testFind() {
		shop.setShop_id(1);
		Assert.assertNotNull(dao.find(shop));
		System.out.println(dao.find(shop));
	}

	@Test
	public void testFindAll() {
		Assert.assertEquals(dao.findAll().isEmpty(), false);
		System.out.println(dao.findAll());
	}

	@Test
	public void testInsert() {
		shop.setShop_id(1021);
		shop.setShop_name("广东正宗面馆");
		shop.setShop_pic("http://localhost/1021mianGuang.jpg");
		shop.setBusiness_pic("http://localhost/1021busninessPic.jpg");
		shop.setService_starttime(new Timestamp(0));
		shop.setService_endtime(new Timestamp(100));
		shop.setService_range(10);
		shop.setAddress("珠海市唐家东岸村云姐面馆");
		shop.setDistribution_cost(12.0);
		System.out.println(dao.insert(shop));
	}

	@Test
	public void testModify() {
		shop.setShop_id(1);
		shop.setShop_name("广东正宗面馆");
		shop.setShop_pic("http://localhost/1021mianGuang.jpg");
		shop.setBusiness_pic("http://localhost/1021busninessPic.jpg");
		shop.setService_starttime(new Timestamp(0));
		shop.setService_endtime(new Timestamp(100));
		shop.setService_range(10);
		shop.setAddress("广东省珠海市唐家东岸村云姐面馆");
		shop.setDistribution_cost(12.0);
		System.out.println(dao.modify(shop));
	}

	@Test
	public void testDelete() {
		shop.setShop_id(2);
		Assert.assertNotNull(dao.delete(shop));
	}

}

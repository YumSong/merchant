package com.lames.merchant.dao.newVersion;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.lames.merchant.dao.newVersion.impl.ShopDaoImpl;
import com.lames.merchant.po.Shop;


public class IShopDaoTest {
	private IShopDao dao;
	
	@Before
	public void before() {
		dao = new ShopDaoImpl();
	}

	@Test
	public void testFindByShopId() {
        Shop shop = new Shop();
        shop.setShopId(1);
        Shop shop1 = dao.findByShopId(shop);
        Assert.assertNotNull(shop1);
        System.out.println(shop1);
	}

	@Test
	public void testFindAll() {
		System.out.println(dao.findAll());
	}

	@Test
	public void testSaveShop() {
        Shop shop = new Shop();
        shop.setShopName("Food Bar");
        shop.setServiceStartTime(2000L);
        shop.setServicEndTime(3000L);
        shop.setServiceRange(15);
        shop.setShopPic("/imgs/shopPic1.jpg");
        shop.setBusinessPic("/imgs/businessPic.jpg");
        shop.setDistributionCost(20.0);
        shop.setMerchantId(32);
        Assert.assertEquals(dao.saveShop(shop), 1);		
	}

	@Test
	public void testModifyShop() {
        Shop shop = new Shop();
        shop.setShopId(1);
        shop.setShopName("Food Bar2");
        shop.setServiceStartTime(4000L);
        shop.setServicEndTime(5000L);
        shop.setServiceRange(20);
        shop.setShopPic("/imgs/shopPic2.jpg");
        shop.setBusinessPic("/imgs/businessPic.jpg");
        shop.setAddress("South software park");
        shop.setDistributionCost(20.0);
        shop.setMerchantId(29);
        Assert.assertEquals(dao.modifyShop(shop), 1);
	}

	@Test
	public void testDeleteByShopId() {
		Shop shop = new Shop();
		shop.setShopId(2);
		Assert.assertEquals(dao.deleteByShopId(shop), 1);
	}

	@Test
	public void testFindByMerchantId() {
		Shop shop = new Shop();
		shop.setMerchantId(32);
		Shop shop1 = dao.findByMerchantId(shop);
		Assert.assertNotNull(shop1);
		System.out.println(shop1);
	}
}

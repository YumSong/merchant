package com.lames.merchant.dao.newVersion;

import java.util.List;

import com.lames.merchant.po.Shop;

public interface IShopDao {
	public Shop findByShopId(Shop shop);

	public List<Shop> findAll();
	
	public int saveShop(Shop shop);
	
	public int modifyShop(Shop shop);
	
	public int deleteByShopId(Shop shop);

	public Shop findByMerchantId(Shop shop);
	
	
}

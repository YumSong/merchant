package com.lames.merchant.dao;

import java.util.List;

import com.lames.merchant.model.Shop;

public interface IShopDao {
	public Shop find(Shop shop);
	
	public List<Shop> findAll();
	
	public Shop insert(Shop shop);
	
	public Shop modify(Shop shop);
	
	public Shop delete(Shop shop);

	Shop findByMerchantId(Integer merchantID);

	Shop insertSimple(Shop shop);
	
}

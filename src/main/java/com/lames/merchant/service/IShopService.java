package com.lames.merchant.service;

import java.util.List;

import com.lames.merchant.model.MerchantDetail;
import com.lames.merchant.model.Shop;

public interface IShopService {
	public Shop find(Shop shop);
	
	public List<Shop> findAll();
	
	public Shop insert(Shop shop);
	
	public Shop modify(Shop shop);
	
	public Shop delete(Shop shop);
	

	Shop apply(MerchantDetail detail, Shop reqShop);
}

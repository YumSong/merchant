package com.lames.merchant.service.newVersion;

import java.util.List;

import com.lames.merchant.po.MerchantDetail;
import com.lames.merchant.po.Shop;

public interface IShopService {
	public Shop findByShopId(Shop shop);
	
	public List<Shop> findAll();
	
	public Shop saveShop(Shop shop);
	
	public Shop modifyShop(Shop shop);
	
	public Shop deleteShopById(Shop shop);
	

	Shop apply(MerchantDetail detail, Shop reqShop);
	
	
//	public Shop findByShopId(Shop shop);
//
//	public List<Shop> findAll();
//	
//	public int saveShop(Shop shop);
//	
//	public int modifyShop(Shop shop);
//	
//	public int deleteByShopId(Shop shop);
//
//	public Shop findByMerchantId(Shop shop);	
}

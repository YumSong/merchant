package com.lames.merchant.service.newVersion;

import java.util.List;

import com.lames.merchant.model.Merchant;
import com.lames.merchant.po.MerchantDetail;
import com.lames.merchant.po.Shop;

public interface IShopService {
	public Shop findByShopId(Shop shop);
	
	public Shop findByMerchantId(Merchant merchant);
	
	public List<Shop> findAll();
	
	public Shop saveShop(Shop shop);
	
	public Shop modifyShop(Shop shop);
	
	public Shop deleteByShopId(Shop shop);

	public Shop apply(MerchantDetail detail, Shop reqShop);
}

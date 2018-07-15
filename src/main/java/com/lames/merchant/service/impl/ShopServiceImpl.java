package com.lames.merchant.service.impl;

import java.util.List;

import com.lames.merchant.dao.IShopDao;
import com.lames.merchant.dao.impl.ShopDaoImpl;
import com.lames.merchant.model.MerchantDetail;
import com.lames.merchant.model.Shop;
import com.lames.merchant.service.IShopService;
import com.lames.merchant.util.JMSUtil;
import com.lames.merchant.util.JsonUtil;

public class ShopServiceImpl implements IShopService {
	private IShopDao dao = new ShopDaoImpl(); 
	
	@Override
	public Shop find(Shop shop) {
		return dao.find(shop);
	}

	@Override
	public List<Shop> findAll() {
		return dao.findAll();
	}

	@Override
	public Shop insert(Shop shop) {
		return dao.insert(shop);
	}

	@Override
	public Shop modify(Shop shop) {
		return dao.modify(shop);
	}

	@Override
	public Shop delete(Shop shop) {
		return dao.delete(shop);
	}

	@Override
	public Shop apply(MerchantDetail detail) {
		JMSUtil.send(JsonUtil.objectToJson(detail));
		return null;
	}
	
}

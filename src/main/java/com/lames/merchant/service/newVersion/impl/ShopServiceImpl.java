package com.lames.merchant.service.newVersion.impl;

import java.util.List;

import com.lames.merchant.dao.newVersion.IShopDao;
import com.lames.merchant.dao.newVersion.impl.ShopDaoImpl;
import com.lames.merchant.model.JsonResult;
import com.lames.merchant.model.Merchant;
import com.lames.merchant.po.MerchantDetail;
import com.lames.merchant.po.Shop;
import com.lames.merchant.service.newVersion.IShopService;
import com.lames.merchant.util.JMSUtil;
import com.lames.merchant.util.JsonUtil;

public class ShopServiceImpl implements IShopService {
	private IShopDao dao = new ShopDaoImpl();

	@Override
	public Shop findByShopId(Shop shop) {
		return dao.findByShopId(shop);
	}

	@Override
	public List<Shop> findAll() {
		return dao.findAll();
	}

	@Override
	public Shop saveShop(Shop shop) {
		dao.saveShop(shop);
		return shop;
	}

	@Override
	public Shop modifyShop(Shop shop) {
		int status = dao.modifyShop(shop);
		System.out.println(shop);
		if(status == 0) {
			return null;
		}
		return shop;
	}

	@Override
	public Shop deleteByShopId(Shop shop) {
		int status = dao.deleteByShopId(shop);
		if(status == 0) {
			return null;
		}
		return shop;
	}

	@Override
	public Shop apply(MerchantDetail detail, Shop shop) {
		Shop newShop = dao.findByShopId(shop);
		if(newShop != null) {
			return newShop;
		}else {
			int count = dao.saveShop(shop);
			if(count > 0) {
				newShop = shop;
				JMSUtil.send(JsonUtil.objectToJson(detail));
			}
		}
		return null;
	}

	@Override
	public Shop findByMerchantId(Merchant merchant) {
		if(merchant.getMerchantID() != null) {
			Shop shop = new Shop();
			shop.setMerchantId(merchant.getMerchantID());
			return dao.findByMerchantId(shop);
		}
		return null;
	}

	
	
}

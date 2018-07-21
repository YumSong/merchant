package com.lames.merchant.service.newVersion.impl;

import java.util.List;

import com.lames.merchant.dao.newVersion.IShopDao;
import com.lames.merchant.dao.newVersion.impl.ShopDaoImpl;
import com.lames.merchant.po.MerchantDetail;
import com.lames.merchant.po.Shop;
import com.lames.merchant.service.newVersion.IShopService;


public class ShopServiceImpl implements IShopService {
	private IShopDao dao = new ShopDaoImpl();

	@Override
	public Shop findByShopId(Shop shop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shop> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shop saveShop(Shop shop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shop modifyShop(Shop shop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shop deleteShopById(Shop shop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shop apply(MerchantDetail detail, Shop reqShop) {
		// TODO Auto-generated method stub
		return null;
	}

	
//	@Override
//	public Shop findByShopId(Shop shop) {
//		return dao.findByShopId(shop);
//	}
//
//	@Override
//	public List<Shop> findAll() {
//		return dao.findAll();
//	}
//
//	@Override
//	public Shop insert(Shop shop) {
//		return dao.insert(shop);
//	}
//
//	@Override
//	public Shop modify(Shop shop) {
//		return dao.modify(shop);
//	}
//
//	@Override
//	public Shop delete(Shop shop) {
//		return dao.delete(shop);
//	}
//
//	@Override
//	public Shop apply(MerchantDetail detail,Shop reqShop) {
//		Shop shop = new Shop();
//		
//		if(detail.getShopID() != null) {
//			shop.setShop_id(detail.getShopID());
//			shop.setMerchant_id(detail.getMerchantID());
//			shop = find(shop);
//			if(detail.getBusinessPic() != null) {
//				shop.setBusiness_pic(detail.getBusinessPic());
//				shop.setAddress(detail.getAddress());
//			}
//			modify(shop);
//		}else {
//			reqShop.setMerchant_id(detail.getMerchantID());
//			dao.insert(reqShop);
//			Shop shop2 = dao.findByMerchantId(detail.getMerchantID());
//			shop.setShop_id(shop2.getShop_id());
//		}
//		
//		detail.setShopID(shop.getShop_id());
//		
//		JMSUtil.send(JsonUtil.objectToJson(detail));
//		
//		return shop;
//	}
	
}

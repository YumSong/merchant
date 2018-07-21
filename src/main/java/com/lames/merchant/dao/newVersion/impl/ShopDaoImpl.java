package com.lames.merchant.dao.newVersion.impl;

import java.sql.SQLException;
import java.util.List;

import com.jake.core.Criteria;
import com.jake.core.SqlSession;
import com.lames.merchant.dao.newVersion.IShopDao;
import com.lames.merchant.po.Shop;
import com.lames.merchant.util.SQLSessionUtil;

public class ShopDaoImpl implements IShopDao {

	@Override
	public Shop findByShopId(Shop shop) {
        SqlSession sqlSession = SQLSessionUtil.getSqlSession();
        Shop result = null;
        try {
        	Criteria criteria = new Criteria();
        	criteria.put("shop_id=", shop.getShopId());
        	result = (Shop) sqlSession.find(shop, criteria);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}

	@Override
	public List<Shop> findAll() {
		SqlSession sqlSession = SQLSessionUtil.getSqlSession();
		List<Shop> shopList = null;
		try {
			shopList = sqlSession.findAll(Shop.class);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return shopList;
	}

	@Override
	public int saveShop(Shop shop) {
		SqlSession sqlSession = SQLSessionUtil.getSqlSession();
		int status = 0;
        try {
        	status = sqlSession.save(shop);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();	
		}
        	
		return status;
	}

	@Override
	public int modifyShop(Shop shop) {
		SqlSession sqlSession = SQLSessionUtil.getSqlSession();
		int status = 0;
        try {
			status = sqlSession.update(shop);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return status;
	}

	@Override
	public int deleteByShopId(Shop shop) {
		SqlSession sqlSession = SQLSessionUtil.getSqlSession();
		int status = 0;
		try {
			Criteria criteria = new Criteria();
			criteria.put("shop_id", shop.getShopId());
			status = sqlSession.delete(shop, criteria);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return status;
	}

	@Override
	public Shop findByMerchantId(Shop shop) {
        SqlSession sqlSession = SQLSessionUtil.getSqlSession();
        Shop result = null;
        try {
        	Criteria criteria = new Criteria();
        	criteria.put("merchant_id=", shop.getMerchantId());
        	result = (Shop) sqlSession.find(shop, criteria);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}

}

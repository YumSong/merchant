package com.lames.merchant.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lames.merchant.dao.IShopDao;
import com.lames.merchant.model.Recipe;
import com.lames.merchant.model.Shop;
import com.lames.merchant.util.BDCPUtil;

public class ShopDaoImpl implements IShopDao {

	@Override
	public Shop find(Shop shop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Shop> findAll() {
		Connection conn = BDCPUtil.getConnection();
		String sql = "select shop_id,shop_name,service_starttime,service_endtime," + 
				     "service_range,distribution_cost,shop_pic,business_pic,address from shop";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Shop> shops = new ArrayList<Shop>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Shop shop = new Shop();
				shop.setShop_id(rs.getInt(1));
				shop.setShop_name(rs.getString(2));
				shop.setService_starttime(rs.getDate(3));
				shop.setService_endtime(rs.getDate(4));
				shop.setService_range(rs.getInt(5));
				shop.setDistribution_cost(rs.getDouble(6));
				shop.setShop_pic(rs.getString(7));
			}
			return shops;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public Shop insert(Shop shop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shop modify(Shop shop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Shop delete(Shop shop) {
		// TODO Auto-generated method stub
		return null;
	}

}

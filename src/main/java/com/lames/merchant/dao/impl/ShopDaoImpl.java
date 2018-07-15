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
import com.lames.merchant.util.DBUtil;

public class ShopDaoImpl implements IShopDao {

	@Override
	public Shop find(Shop shop) {
		Connection conn = DBUtil.getConnection();
		String sql = "select shop_id,"
					+ "shop_name,"
					+ "service_starttime,"
					+ "service_endtime," 
					+ "service_range,"
					+ "distribution_cost,"
					+ "shop_pic,"
					+ "business_pic,"
					+ "address from shop where shop_id=?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Shop shop1 = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, shop.getShop_id());
			rs = ps.executeQuery();
			while(rs.next()) {
				shop1 = new Shop();
				shop1.setShop_id(rs.getInt(1));
				shop1.setShop_name(rs.getString(2));
				shop1.setService_starttime(rs.getTimestamp(3));
				shop1.setService_endtime(rs.getTimestamp(4));
				shop1.setService_range(rs.getInt(5));
				shop1.setDistribution_cost(rs.getDouble(6));
				shop1.setShop_pic(rs.getString(7));
				shop1.setBusiness_pic(rs.getString(8));
				shop1.setAddress(rs.getString(9));
			}
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
		return shop1;
	}

	@Override
	public List<Shop> findAll() {
		Connection conn = DBUtil.getConnection();
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
				shop.setService_starttime(rs.getTimestamp(3));
				shop.setService_endtime(rs.getTimestamp(4));
				shop.setService_range(rs.getInt(5));
				shop.setDistribution_cost(rs.getDouble(6));
				shop.setShop_pic(rs.getString(7));
				shop.setBusiness_pic(rs.getString(8));
				shop.setAddress(rs.getString(9));
				shops.add(shop);
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
		Connection conn = DBUtil.getConnection();
		String sql = "insert into shop(shop_id,shop_name,service_starttime,service_endtime," + 
				     "service_range,distribution_cost,shop_pic,business_pic,address) " + 
				     "values(S_shop.nextVal,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = null;
		int status = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, shop.getShop_name());
			ps.setTimestamp(2, shop.getService_starttime());
			ps.setTimestamp(3, shop.getService_endtime());
			ps.setInt(4, shop.getService_range());
			ps.setDouble(5, shop.getDistribution_cost());
			ps.setString(6, shop.getShop_pic());
			ps.setString(7, shop.getBusiness_pic());
			ps.setString(8, shop.getAddress());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(status == 0) 	
			return null;
		return shop;
	}

	@Override
	public Shop modify(Shop shop) {
		Connection conn = DBUtil.getConnection();
		String sql = "update shop set shop_name=?," + 
				"				service_starttime=?," + 
				"				service_endtime=?," + 
				"				service_range=?," + 
				"				distribution_cost=?," + 
				"				shop_pic=?," + 
				"				business_pic=?," + 
				"				address=? where shop_id=?";
		PreparedStatement ps = null;
		int status = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, shop.getShop_name());
			ps.setTimestamp(2, shop.getService_starttime());
			ps.setTimestamp(3, shop.getService_endtime());
			ps.setInt(4, shop.getService_range());
			ps.setDouble(5, shop.getDistribution_cost());
			ps.setString(6, shop.getShop_pic());
			ps.setString(7, shop.getBusiness_pic());
			ps.setString(8, shop.getAddress());
			ps.setInt(9, shop.getShop_id());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(status == 0) 	
			return null;
		return shop;
	}

	@Override
	public Shop delete(Shop shop) {
		Connection conn = DBUtil.getConnection();
		String sql = "delete from shop where shop_id =?";
		PreparedStatement ps = null;
		int status = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, shop.getShop_id());
			status = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(status == 0) 	
			return null;
		return shop;
	}
}

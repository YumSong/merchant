package com.lames.merchant.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lames.merchant.dao.IRecipeDao;
import com.lames.merchant.model.Recipe;
import com.lames.merchant.util.BDCPUtil;

public class RecipeDaoImpl implements IRecipeDao {

	@Override
	public Recipe find(Recipe recipe) {
		Connection conn = BDCPUtil.getConnection();
		String sql = "select re_id,re_name,re_pic,detail,price,shop_id from recipe where re_id =?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Recipe recipe1 = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, recipe.getRe_id());
			rs = ps.executeQuery();
			while(rs.next()) {
				recipe1 = new Recipe();
				recipe1.setRe_id(rs.getInt(1));
				recipe1.setRe_name(rs.getString(2));
				recipe1.setRe_pic(rs.getString(3));
				recipe1.setDetail(rs.getString(4));
				recipe1.setPrice(rs.getDouble(5));
				recipe1.setShop_id(rs.getInt(6));
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
		return recipe1;
	}
	
	@Override
	public List<Recipe> findAll() {
		Connection conn = BDCPUtil.getConnection();
		String sql = "select re_id,re_name,re_pic,detail,price,shop_id from recipe";
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Recipe> recipes = new ArrayList<Recipe>();
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Recipe recipe = new Recipe();
				recipe.setRe_id(rs.getInt(1));
				recipe.setRe_name(rs.getString(2));
				recipe.setRe_pic(rs.getString(3));
				recipe.setDetail(rs.getString(4));
				recipe.setPrice(rs.getDouble(5));
				recipe.setShop_id(rs.getInt(6));
				recipes.add(recipe);
			}
			return recipes;
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

	//注意所有sql语句不能加分号结束
	@Override
	public Recipe insert(Recipe recipe) {
		Connection conn = BDCPUtil.getConnection();
		String sql = "insert into recipe(re_id,re_name,re_pic,detail,price,shop_id)" + 
				      "values(S_recipe.nextVal,?,?,?,?,?)";
		PreparedStatement ps = null;
		int status = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, recipe.getRe_name());
			ps.setString(2, recipe.getRe_pic());
			ps.setString(3, recipe.getDetail());
			ps.setDouble(4, recipe.getPrice());
			ps.setInt(5, recipe.getShop_id());
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
		return recipe;
	}


	@Override
	public Recipe modify(Recipe recipe) {
		Connection conn = BDCPUtil.getConnection();
		String sql = "update recipe set re_name=?,re_pic=?,detail=?,price=?,shop_id=? where re_id=?";
		PreparedStatement ps = null;
		int status = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, recipe.getRe_name());
			ps.setString(2, recipe.getRe_pic());
			ps.setString(3, recipe.getDetail());
			ps.setDouble(4, recipe.getPrice());
			ps.setInt(5, recipe.getShop_id());
			ps.setInt(6,recipe.getRe_id());
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
		return recipe;
	}

	@Override
	public Recipe delete(Recipe recipe) {
		Connection conn = BDCPUtil.getConnection();
		String sql = "delete from recipe where re_id=?";
		PreparedStatement ps = null;
		int status = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,recipe.getRe_id());
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
		return recipe;
	}

}

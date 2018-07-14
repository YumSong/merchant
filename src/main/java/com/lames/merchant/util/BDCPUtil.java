package com.lames.merchant.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class BDCPUtil {
	private static String divername = "oracle.jdbc.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String user = "system";
	private static String password = "root";
	private static BasicDataSource ds;
	
	static {
		ds = new BasicDataSource();
		ds.setDriverClassName(divername);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(password);
		
		
		ds.setInitialSize(20); // 初始连接数量
		ds.setMinIdle(3); //最少保持几条空闲的连接
		ds.setMaxTotal(1000); //最大连接数量
		ds.setMaxWaitMillis(10000); //最大等待时间
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}

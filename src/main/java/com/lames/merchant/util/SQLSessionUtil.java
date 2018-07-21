package com.lames.merchant.util;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.jake.core.SqlSession;
import com.jake.core.SqlSessionFactory;

public class SQLSessionUtil {
	private static SqlSessionFactory factory;
	
	static {
		Properties properties = FileUtil.loadReasource("db/jdbc.properties");
		factory = new SqlSessionFactory(properties.getProperty("model.package"));
		DataSource ds = new BasicDataSource();
		
		
		((BasicDataSource) ds).setDriverClassName(properties.getProperty("jdbc.divername"));
		((BasicDataSource) ds).setUrl(properties.getProperty("jdbc.url"));
		((BasicDataSource) ds).setUsername(properties.getProperty("jdbc.user"));
		((BasicDataSource) ds).setPassword(properties.getProperty("jdbc.password"));
		
		((BasicDataSource) ds).setInitialSize(20); // 初始连接数量
		((BasicDataSource) ds).setMinIdle(3); //最少保持几条空闲的连接
		((BasicDataSource) ds).setMaxTotal(1000); //最大连接数量
		((BasicDataSource) ds).setMaxWaitMillis(10000); //最大等待时间
		
        factory.setDataSource(ds);
	}
	
	public static SqlSession getSqlSession() {
		return factory.createSqlSession();
	}
}

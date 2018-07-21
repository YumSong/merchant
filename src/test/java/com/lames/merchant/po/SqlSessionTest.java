package com.lames.merchant.po;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jake.core.SqlSession;
import com.jake.core.SqlSessionFactory;
import com.lames.merchant.po.Shop;


public class SqlSessionTest {

//    SqlSessionFactory factory = new SqlSessionFactory("com.lames.merchant.po");
//
//    @Before
//    public void before(){
//        DataSource ds = new BasicDataSource();
//        ((BasicDataSource) ds).setUsername("system");
//        ((BasicDataSource) ds).setPassword("root");
//        ((BasicDataSource) ds).setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//        ((BasicDataSource) ds).setDriverClassName("oracle.jdbc.OracleDriver");
//        factory.setDataSource(ds);
//    }
//
//    @Test
//    public void testSaveShop() throws SQLException {
//        SqlSession sqlSession = factory.createSqlSession();
//        Shop shop = new Shop();
//        shop.setShopName("Drink Bar3");
//        shop.setServiceStartTime(2000);
//        shop.setServicEndTime(3000);
//        shop.setServiceRange(20);
//        shop.setShopPic("/imgs/shopPic1.jpg");
//        shop.setBusinessPic("/imgs/businessPic.jpg");
//        shop.setDistributionCost(20.0);
//        shop.setMerchantId(30);
//        sqlSession.save(shop);
//        sqlSession.close();
//        
//    }
//    
//
//    @Test
//    public void testSaveNullShop() throws Exception {
//        SqlSession sqlSession = factory.createSqlSession();
//        Shop shop = new Shop();
//        Assert.assertEquals(sqlSession.save(shop), 0);
//        sqlSession.close();
//    }
//    
//
//    @Test
//    public void testUpdateShop() throws SQLException {
//        SqlSession sqlSession = factory.createSqlSession();
//        Shop shop = new Shop();
//        shop.setShopId(2);
//        shop.setShopName("Drink Bar3");
//        shop.setServiceStartTime(4000);
//        shop.setServicEndTime(5000);
//        shop.setServiceRange(20);
//        shop.setShopPic("/imgs/shopPic2.jpg");
//        shop.setBusinessPic("/imgs/businessPic.jpg");
//        shop.setAddress(null);
//        shop.setDistributionCost(20.0);
//        shop.setMerchantId(30);
//        sqlSession.update(shop, shop.getShopId());
//        sqlSession.close();
//    }
//
//    @Test
//    public void testDeleteShop() throws SQLException {
//        SqlSession sqlSession = factory.createSqlSession();
//        
//        sqlSession.delete(Shop.class,1);
//        sqlSession.close();
//    }
//
//    @Test
//    public void testFindShop() throws SQLException {
//        SqlSession sqlSession = factory.createSqlSession();
//        Shop shop = new Shop();
//        shop.setShopId(1);
//        
//        Shop shop1 = (Shop) sqlSession.find(shop);
//        System.out.println(shop1);
//    }
//
//    @Test
//    public void testFindAll() throws SQLException {
//        SqlSession sqlSession = factory.createSqlSession();
//        
//        List<Shop> shopList =  sqlSession.findAll(Shop.class);
//        System.out.println(shopList);
//    }
}

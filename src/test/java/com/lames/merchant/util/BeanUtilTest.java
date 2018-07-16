package com.lames.merchant.util;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.core.Is;
import org.junit.Test;

import com.lames.merchant.model.Merchant;

public class BeanUtilTest {

	/*@Test
	public void testMapToBean() {
		Map<String, Object> map = new HashMap<>();
		map.put("loginName", "Hello");
		map.put("loginPassword", "world");
		map.put("merchantID", 007);
		map.put("notExistField", "notExistField");
		
		Merchant merchant = (Merchant) BeanUtil.mapToBean(map, Merchant.class);
		assertThat("Hello", is(merchant.getLoginName()));
		assertThat("world", is(merchant.getLoginPassword()));
		assertThat(007, is(merchant.getMerchantID()));
		
	}
	
	@Test
	public void testBeanToMap() {
		Merchant merchant = new Merchant();
		merchant.setLoginName("Hello");
		merchant.setLoginPassword("World");
		merchant.setMerchantID(007);
		
		Map<String, Object> map = BeanUtil.beanToMap(merchant);
		assertThat(map.get("loginName"), is("Hello"));
		assertThat(map.get("loginPassword"), is("World"));
		assertThat(map.get("merchantID"), is(007));
	}*/

}

package com.lames.merchant.service.impl;

import java.io.IOException;
import java.util.Map;

import com.jake.util.BeanUtil;
import com.lames.merchant.config.Config;
import com.lames.merchant.config.WebServiceConfig;
import com.lames.merchant.model.JsonResult;
import com.lames.merchant.model.Merchant;
import com.lames.merchant.model.MerchantDetailStatus;
import com.lames.merchant.po.MerchantDetail;
import com.lames.merchant.po.Shop;
import com.lames.merchant.service.IMerchantService;
import com.lames.merchant.service.newVersion.IShopService;
import com.lames.merchant.service.newVersion.impl.ShopServiceImpl;
import com.lames.merchant.util.JsonUtil;
import com.lames.merchant.util.WebConnection;

public class MerchantServiceImpl implements IMerchantService {
	
	private IShopService shopService = new ShopServiceImpl();
	
	@Override
	public JsonResult login(Merchant merchant) {
		Config config = WebServiceConfig.getConfig();
		WebConnection conn = new WebConnection(config.get("merchant.server") + config.get("merchant.login"));
		conn.setHeader("content-type", WebConnection.STANDARD_FORM_DATA);
		conn.setParameter("loginName", merchant.getLoginName());
		conn.setParameter("loginPassword", merchant.getLoginPassword());
		JsonResult result = null;
		try {
			String str = conn.post();
			result = (JsonResult) JsonUtil.jsonToObject(str, JsonResult.class);
		} catch (IOException e) {
			result = new JsonResult();
			result.setStatus(false);
			result.setMessage("连接管理服务器失败...");
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public JsonResult register(Merchant merchant) {
		Config config = WebServiceConfig.getConfig();
		WebConnection conn = new WebConnection(config.get("merchant.server") + config.get("merchant.register"));
		conn.setHeader("content-type", WebConnection.STANDARD_FORM_DATA);
		conn.setParameter("loginName", merchant.getLoginName());
		conn.setParameter("loginPassword", merchant.getLoginPassword());
		JsonResult result = null;
		try {
			String str = conn.post();
			result = (JsonResult) JsonUtil.jsonToObject(str, JsonResult.class);
		} catch (IOException e) {
			result = new JsonResult();
			result.setStatus(false);
			result.setMessage("连接管理服务器失败...");
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * Return merchantDetail of merchant
	 * @Merchant
	 */
	@Override
	public MerchantDetail detail(Merchant merchant) {
		Shop shop = shopService.findByMerchantId(merchant);
		merchant.setShop(shop);
		if(shop != null) {
			Config config = WebServiceConfig.getConfig();
			WebConnection conn = new WebConnection(config.get("merchant.server") + config.get("merchant.details"));
			conn.setHeader("content-type", WebConnection.STANDARD_FORM_DATA);
			conn.setParameter("merchantID", merchant.getMerchantID() + "");
			JsonResult result;
			try {
				String str = conn.post();
				result = (JsonResult) JsonUtil.jsonToObject(str, JsonResult.class);
				
				if(result.isStatus()) {
					Map map = (Map)result.getData("merchantDetail");
					MerchantDetail detail = (MerchantDetail) BeanUtil.mapToBean(map, MerchantDetail.class);
					merchant.setMerchantDetail(detail);
				}
			} catch (IOException e) {
				result = new JsonResult();
				result.setStatus(false);
				result.setMessage("连接管理服务器失败...");
				e.printStackTrace();
			}
		}
		
		return null;
	}

}

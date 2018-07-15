package com.lames.merchant.service.impl;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.Part;

import com.lames.merchant.config.Config;
import com.lames.merchant.config.WebServiceConfig;
import com.lames.merchant.model.JsonResult;
import com.lames.merchant.model.Merchant;
import com.lames.merchant.service.IMerchantService;
import com.lames.merchant.util.JsonUtil;
import com.lames.merchant.util.WebConnection;

public class MerchantService implements IMerchantService {

	@Override
	public Merchant login(Merchant merchant) {
		Config config = WebServiceConfig.getConfig();
		WebConnection conn = new WebConnection(config.get("merchant.login"));
		conn.setParameter("loginName", merchant.getLoginName());
		conn.setParameter("loginPassword", merchant.getLoginName());
		try {
			String str = conn.post();
			JsonResult result = (JsonResult) JsonUtil.jsonToObject(str, JsonResult.class);
			if(result.isStatus()) {
				Map merchatMap =  (Map) result.getData("merchant");
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Merchant register(Merchant merchant) {
		return merchant;
	}

}

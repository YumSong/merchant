package com.lames.merchant.service;

import com.lames.merchant.model.JsonResult;
import com.lames.merchant.model.Merchant;
import com.lames.merchant.model.MerchantDetail;

public interface IMerchantService {

	JsonResult login(Merchant merchant);
	JsonResult register(Merchant merchant);
	MerchantDetail detail(Merchant merchant);
}

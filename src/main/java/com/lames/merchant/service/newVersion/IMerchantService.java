package com.lames.merchant.service.newVersion;

import com.lames.merchant.model.JsonResult;
import com.lames.merchant.model.Merchant;

public interface IMerchantService {

	JsonResult login(Merchant merchant);
	JsonResult register(Merchant merchant);
	JsonResult detail(Merchant merchant);
}

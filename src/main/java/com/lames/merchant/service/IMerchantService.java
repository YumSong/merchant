package com.lames.merchant.service;

import com.lames.merchant.model.Merchant;

public interface IMerchantService {

	Merchant login(Merchant merchant);
	Merchant register(Merchant merchant);
}

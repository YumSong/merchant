package com.lames.merchant.model;

import com.jake.annotation.Length;
import com.jake.annotation.NotNull;

public class Merchant {

	@NotNull(message="登录名不能为空")
	@Length(min=5,max=30,message="用户名长度应在5-30位之间")
	private String loginName;
	@NotNull(message="密码不能为空")
	@Length(min=5,max=30,message="密码长度应在5-30位之间")
	private String loginPassword;
	private Integer merchantID;
	com.lames.merchant.po.Shop shop;
	com.lames.merchant.po.MerchantDetail merchantDetail;
	
	
	
	

	public com.lames.merchant.po.Shop getShop() {
		return shop;
	}

	public void setShop(com.lames.merchant.po.Shop shop) {
		this.shop = shop;
	}

	public com.lames.merchant.po.MerchantDetail getMerchantDetail() {
		return merchantDetail;
	}

	public void setMerchantDetail(com.lames.merchant.po.MerchantDetail merchantDetail) {
		this.merchantDetail = merchantDetail;
	}

	public Merchant() {
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public Integer getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(Integer merchantID) {
		this.merchantID = merchantID;
	}

	@Override
	public String toString() {
		return "Merchant [loginName=" + loginName + ", loginPassword=" + loginPassword + ", merchantID=" + merchantID
				+ "]";
	}

	
}

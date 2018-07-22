package com.lames.merchant.po;

import com.jake.annotation.Length;
import com.jake.annotation.NotNull;
import com.jake.annotation.Regex;


public class MerchantDetail {

	private Integer merchantDetailID;
	private Integer merchantID;
	@Regex(reg="\\d{17}(X|\\d)",message="身份证格式错误")
	private String idcardNum;
	@NotNull(message="身份证照片不能为空")
	private String idcardPic;
	@Length(message="商家名字长度应在1-30位之间",min=1,max=30)
	private String merchantName;
	private Integer shopID;
	private Integer status;// 狀態：0-待處理、 1-審核通過（拉白）、 2-駁回 3、不同意（拉黑）
	@NotNull(message="店内图片不能为空")
	private String[] shopPic;
	@NotNull(message="营业执照不能为空")
	private String businessPic;
	@Length(min=1,max=100,message="店铺地址应在1-100字之间")
	private String address;
	@Length(min=1,max=200,message="店铺介绍应在1-200字之间")
	private String introduction;
	

	public MerchantDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getMerchantDetailID() {
		return merchantDetailID;
	}

	public void setMerchantDetailID(Integer merchantDetailID) {
		this.merchantDetailID = merchantDetailID;
	}

	public Integer getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(Integer merchantID) {
		this.merchantID = merchantID;
	}

	
	public String getIdcardNum() {
		return idcardNum;
	}

	public void setIdcardNum(String idcardNum) {
		this.idcardNum = idcardNum;
	}

	public String getIdcardPic() {
		return idcardPic;
	}

	public void setIdcardPic(String idcardPic) {
		this.idcardPic = idcardPic;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public Integer getShopID() {
		return shopID;
	}

	public void setShopID(Integer shopID) {
		this.shopID = shopID;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}




	public String getBusinessPic() {
		return businessPic;
	}

	public void setBusinessPic(String businessPic) {
		this.businessPic = businessPic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	
	public String[] getShopPic() {
		return shopPic;
	}

	public void setShopPic(String[] shopPic) {
		this.shopPic = shopPic;
	}

	@Override
	public String toString() {
		return "MerchantDetail [merchantDetailID=" + merchantDetailID + ", merchantID=" + merchantID + ", idcardNum="
				+ idcardNum + ", idcardPic=" + idcardPic + ", merchantName=" + merchantName + ", shopID=" + shopID
				+ ", status=" + status + ", shopPic=" + shopPic + ", businessPic=" + businessPic + ", address="
				+ address + ", introduction=" + introduction + "]";
	}

	

}

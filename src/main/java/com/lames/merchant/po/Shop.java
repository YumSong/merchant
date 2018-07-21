package com.lames.merchant.po;


import com.jake.annotation.Column;
import com.jake.annotation.Entity;
import com.jake.annotation.ID;
import com.jake.annotation.Sequence;

@Entity("Shop")
public class Shop {
	@ID()
	@Sequence("S_shop")
	@Column("shop_id")
	private Integer shopId;
	@Column("shop_name")
	private String shopName;
	@Column("service_starttime")
	private Long serviceStartTime;
	@Column("service_endtime")
	private Long servicEndTime;
	@Column("service_range")
	private Integer serviceRange;
	@Column("distribution_cost")
	private Double distributionCost;
	@Column("shop_pic")
	private String shopPic;
	@Column("business_pic")
	private String businessPic;
	@Column("address")
	private String address;
	@Column("merchant_id")
	
	private Integer merchantId;
	
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Integer getServiceRange() {
		return serviceRange;
	}
	public void setServiceRange(Integer serviceRange) {
		this.serviceRange = serviceRange;
	}
	public Double getDistributionCost() {
		return distributionCost;
	}
	public void setDistributionCost(Double distributionCost) {
		this.distributionCost = distributionCost;
	}
	public String getShopPic() {
		return shopPic;
	}
	public void setShopPic(String shopPic) {
		this.shopPic = shopPic;
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
	public Integer getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
	}
	
	public Long getServiceStartTime() {
		return serviceStartTime;
	}
	public void setServiceStartTime(Long serviceStartTime) {
		this.serviceStartTime = serviceStartTime;
	}
	public Long getServicEndTime() {
		return servicEndTime;
	}
	public void setServicEndTime(Long servicEndTime) {
		this.servicEndTime = servicEndTime;
	}
	@Override
	public String toString() {
		return "Shop [shopId=" + shopId + ", shopName=" + shopName + ", serviceStartTime=" + serviceStartTime
				+ ", servicEndTime=" + servicEndTime + ", serviceRange=" + serviceRange + ", distributionCost="
				+ distributionCost + ", shopPic=" + shopPic + ", businessPic=" + businessPic + ", address=" + address
				+ ", merchantId=" + merchantId + "]\n";
	}
	

}

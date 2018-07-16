package com.lames.merchant.model;

import java.sql.Timestamp;

public class Shop {
	private Integer shop_id;
	private String shop_name;
	private Timestamp service_starttime;
	private Timestamp service_endtime;
	private Integer service_range;
	private Double distribution_cost;
	private String shop_pic;
	private String business_pic;
	private String address;
	private Integer merchant_id;

	public Shop() {}

	public Shop(String shop_name, Timestamp service_starttime, Timestamp service_endtime, Integer service_range,
			Double distribution_cost, String shop_pic, String business_pic, String address, Integer merchant_id) {
		this.shop_name = shop_name;
		this.service_starttime = service_starttime;
		this.service_endtime = service_endtime;
		this.service_range = service_range;
		this.distribution_cost = distribution_cost;
		this.shop_pic = shop_pic;
		this.business_pic = business_pic;
		this.address = address;
		this.merchant_id = merchant_id;
	}


	public Integer getMerchant_id() {
		return merchant_id;
	}

	public void setMerchant_id(Integer merchant_id) {
		this.merchant_id = merchant_id;
	}

	public Integer getShop_id() {
		return shop_id;
	}

	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}

	public String getShop_name() {
		return shop_name;
	}
	
	
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}

	public Timestamp getService_starttime() {
		return service_starttime;
	}

	public void setService_starttime(Timestamp service_starttime) {
		this.service_starttime = service_starttime;
	}

	public Timestamp getService_endtime() {
		return service_endtime;
	}

	public void setService_endtime(Timestamp service_endtime) {
		this.service_endtime = service_endtime;
	}

	public Integer getService_range() {
		return service_range;
	}

	public void setService_range(Integer service_range) {
		this.service_range = service_range;
	}

	public Double getDistribution_cost() {
		return distribution_cost;
	}

	public void setDistribution_cost(Double distribution_cost) {
		this.distribution_cost = distribution_cost;
	}

	public String getShop_pic() {
		return shop_pic;
	}

	public void setShop_pic(String shop_pic) {
		this.shop_pic = shop_pic;
	}

	public String getBusiness_pic() {
		return business_pic;
	}

	public void setBusiness_pic(String business_pic) {
		this.business_pic = business_pic;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Shop [shop_id=" + shop_id + ", shop_name=" + shop_name + ", service_starttime=" + service_starttime
				+ ", service_endtime=" + service_endtime + ", service_range=" + service_range + ", distribution_cost="
				+ distribution_cost + ", shop_pic=" + shop_pic + ", business_pic=" + business_pic + ", address="
				+ address + "]\n";
	}

}

package com.lames.merchant.model;

public class Recipe {
	private Integer re_id;
	private String re_name;
	private String re_pic;
	private String detail;
	private Double price;
	private Integer shop_id;
	
	public Recipe() {}
	
	public Recipe(String re_name, String re_pic, String detail, Double price, Integer shop_id) {
		this.re_name = re_name;
		this.re_pic = re_pic;
		this.detail = detail;
		this.price = price;
		this.shop_id = shop_id;
	}

	public Recipe(String re_name, String re_pic, String detail, Double price) {
		super();
		this.re_name = re_name;
		this.re_pic = re_pic;
		this.detail = detail;
		this.price = price;
	}

	public Integer getRe_id() {
		return re_id;
	}

	public void setRe_id(Integer re_id) {
		this.re_id = re_id;
	}


	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getShop_id() {
		return shop_id;
	}

	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}

	public String getRe_name() {
		return re_name;
	}
	
	public void setRe_name(String re_name) {
		this.re_name = re_name;
	}
	
	public String getRe_pic() {
		return re_pic;
	}
	
	public void setRe_pic(String re_pic) {
		this.re_pic = re_pic;
	}
	
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Recipe [re_id=" + re_id + ", re_name=" + re_name + ", re_pic=" + re_pic + ", detail=" + detail
				+ ", price=" + price + ", shop_id=" + shop_id + "]\n";
	}
	
	
}

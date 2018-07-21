package com.lames.merchant.po;

import com.jake.annotation.Column;
import com.jake.annotation.Entity;
import com.jake.annotation.ID;
import com.jake.annotation.Sequence;

@Entity("recipe")
public class Recipe {
	@ID()
	@Sequence("S_recipe")
	@Column("re_id")
	private Integer recipeId;
	@Column("re_name")
	private String recipeName;
	@Column("re_pic")
	private String recipePic;
	@Column("detail")
	private String recipeDetail;
	@Column("price")
	private Double recipePrice;
	@Column("shop_id")
	private Integer shopId;
	public Integer getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(Integer recipeId) {
		this.recipeId = recipeId;
	}
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getRecipePic() {
		return recipePic;
	}
	public void setRecipePic(String recipePic) {
		this.recipePic = recipePic;
	}
	public String getRecipeDetail() {
		return recipeDetail;
	}
	public void setRecipeDetail(String recipeDetail) {
		this.recipeDetail = recipeDetail;
	}
	
	public Double getRecipePrice() {
		return recipePrice;
	}
	public void setRecipePrice(Double recipePrice) {
		this.recipePrice = recipePrice;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", recipeName=" + recipeName + ", recipePic=" + recipePic
				+ ", recipeDetail=" + recipeDetail + ", recipePrice=" + recipePrice + ", shopId=" + shopId + "]\n";
	}
	
	
}

package com.lames.merchant.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jake.webmvc.annotation.Controller;
import com.jake.webmvc.annotation.Mapping;
import com.lames.merchant.po.Shop;
import com.lames.merchant.service.newVersion.IShopService;
import com.lames.merchant.service.newVersion.impl.ShopServiceImpl;

@Controller
@Mapping("/shop")
public class ShopController {
	IShopService service = new ShopServiceImpl();
  
  @Mapping("/apply")
	public void apply(MerchantDetail detail,HttpServletResponse response) throws IOException {
		System.out.println(detail);
		List<com.jake.model.Error> errors = ValidatorExecutor.validate(detail);
		JsonResult jsonResult = new JsonResult();
		if(errors.size() > 0) {
			jsonResult.setStatus(false);
			jsonResult.setData("errors", errors);
		}
		
		response.getWriter().write(JsonUtil.objectToJson(jsonResult));
	}
	
	@Mapping("/modify")
	public void modifyShop(Shop shop, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(shop);
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		service.modifyShop(shop);
		writer.write("{\"status\":\"success\"}");
	}
	
	@Mapping("/list")
	public void listShop(Shop shop, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		service.findByShopId(shop);
	}	
	
	@Mapping("/save")
	public void saveShop(Shop shop, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		if(service.saveShop(shop)!=null) {
			writer.write("{\"status\":\"success\"}");
		}else {
			writer.write("{\"status\":\"fail\"}");
		}
	}	
}


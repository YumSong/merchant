package com.lames.merchant.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jake.webmvc.annotation.Controller;
import com.jake.webmvc.annotation.Mapping;
import com.lames.merchant.model.JsonResult;
import com.lames.merchant.po.Shop;
import com.lames.merchant.service.newVersion.IShopService;
import com.lames.merchant.service.newVersion.impl.ShopServiceImpl;
import com.lames.merchant.util.JsonUtil;

@Controller
@Mapping("/shop")
public class ShopController {
	IShopService service = new ShopServiceImpl();
	
	@Mapping("/modify")
	public void modifyShop(Shop shop, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(shop);
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		JsonResult result = new JsonResult();
		if(service.modifyShop(shop) != null) {
			result.setStatus(true);
			result.setMessage("修改成功!");
		}else {
			result.setStatus(false);
			result.setMessage("修改失败!");
		}
		writer.write(JsonUtil.objectToJson(result));
	}
	
	@Mapping("/list")
	public void listShop(Shop shop, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		JsonResult result = new JsonResult();
		Shop shop1 = service.findByShopId(shop);
		if(shop1 != null) {
			result.setStatus(true);
			result.setMessage("修改成功!");
			result.setData("shop", shop1);
		}else {
			result.setStatus(false);
			result.setMessage("修改失败!");
		}
		writer.write(JsonUtil.objectToJson(result));
	}	
	
	@Mapping("/save")
	public void saveShop(Shop shop, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		JsonResult result = new JsonResult();
		if(service.saveShop(shop) != null) {
			result.setStatus(true);
			result.setMessage("添加成功!");
		}else {
			result.setStatus(false);
			result.setMessage("添加失败!");
		}
		writer.write(JsonUtil.objectToJson(result));
	}		

}

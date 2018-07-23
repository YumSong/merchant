package com.lames.merchant.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jake.ValidatorExecutor;
import com.jake.webmvc.annotation.Controller;
import com.jake.webmvc.annotation.Mapping;
import com.lames.merchant.model.JsonResult;
import com.lames.merchant.model.Merchant;
import com.lames.merchant.po.MerchantDetail;
import com.lames.merchant.po.Shop;
import com.lames.merchant.service.newVersion.IShopService;
import com.lames.merchant.service.newVersion.impl.ShopServiceImpl;
import com.lames.merchant.util.JsonUtil;

@Controller
@Mapping("/shop")
public class ShopController {
	IShopService service = new ShopServiceImpl();
	
	@Mapping("/new")
	public void newShop(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException {
		Merchant merchant = (Merchant) session.getAttribute("merchant");
		if(merchant == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}else {
			MerchantDetail detail = merchant.getMerchantDetail();
			Shop shop = merchant.getShop();
			System.out.println(detail);
			System.out.println(shop);
			if(detail == null && shop == null) {
				request.getRequestDispatcher("/WEB-INF/jsp/shop_form.jsp").forward(request, response);
			}else {
				response.sendRedirect(request.getContextPath() + "/merchant/detail");
			}
		}
	}
  
	@Mapping("/apply")
	public void apply(MerchantDetail detail,Shop shop,HttpServletResponse response,HttpServletRequest request,HttpSession session) throws IOException {
		System.out.println(detail);
		Merchant merchant = (Merchant) session.getAttribute("merchant");
		if(merchant == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}else {
			JsonResult jsonResult = new JsonResult();
			jsonResult.setStatus(false);
			List<com.jake.model.Error> errors = ValidatorExecutor.validate(detail);
			if(errors.size() > 0) {
				jsonResult.setData("errors", errors);
			}else {
				detail.setMerchantID(merchant.getMerchantID());
				shop.setMerchantId(merchant.getMerchantID());
				Shop newShop = service.apply(detail,shop);
				if(newShop == null) {
					merchant.setShop(shop);
					jsonResult.setStatus(true);
				}else {
					jsonResult.setMessage("插入失败");
				}
			}

			response.getWriter().write(JsonUtil.objectToJson(jsonResult));
		}
	}
	
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
  
	@Mapping("/shopIndex")
	public void listAllShop(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
//		Merchant merchant = (Merchant) session.getAttribute("merchant");
		Merchant merchant = new Merchant();
		merchant.setMerchantID(258);
		Shop shop = (Shop) service.findByMerchantId(merchant);

		String[] shopPics = shop.getShopPic().split(";;");
		System.out.println(shop);
		request.setAttribute("shopPics", shopPics);	
		request.setAttribute("shop", shop);
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		request.setAttribute("serviceStartTime", formatter.format(new Date(shop.getServiceStartTime())));
		request.setAttribute("servicEndTime", formatter.format(new Date(shop.getServicEndTime())));
		request.setAttribute("addShopPic", "58c081e/f324097/368367e/81c75c77bcd.jpg");
		request.getRequestDispatcher("/shopManager.jsp").forward(request, response);
	}	  
}

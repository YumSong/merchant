package com.lames.merchant.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jake.webmvc.annotation.Controller;
import com.jake.webmvc.annotation.Mapping;
import com.lames.merchant.model.JsonResult;
import com.lames.merchant.model.Merchant;
import com.lames.merchant.service.IMerchantService;
import com.lames.merchant.service.impl.MerchantServiceImpl;
import com.lames.merchant.util.BeanUtil;


@Controller
@Mapping("/merchant")
public class MerchantController {
	
	private IMerchantService service = new MerchantServiceImpl();

	@Mapping("/login")
	public void login(Merchant merchant,HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		JsonResult result = service.login(merchant);
		System.out.println(result);
		if(result.isStatus()) {
			Merchant loginMerChant = (Merchant) BeanUtil.mapToBean((Map)result.getData("merchant"),Merchant.class);
			request.getSession().setAttribute("merchant", loginMerChant);
			response.sendRedirect(request.getContextPath() + "/merchant/detail");
		}else {
			request.setAttribute("error", result.getMessage());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
	
	@Mapping("/register")
	public void register(Merchant merchant,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		JsonResult result = service.register(merchant);
		if(result.isStatus()) {
			Merchant loginMerChant = (Merchant) BeanUtil.mapToBean((Map)result.getData("merchant"),Merchant.class);
			request.getSession().setAttribute("merchant", loginMerChant);
			response.sendRedirect(request.getContextPath() + "/merchant/detail");
		}else {
			request.setAttribute("error", result.getMessage());
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		}
	}
	
	
	@Mapping("/detail")
	public void detail(HttpSession session, HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		Merchant merchant = (Merchant) session.getAttribute("merchant");
		
		if(merchant == null || merchant.getMerchantID() == null) {
			response.sendRedirect(request.getServletPath() + "/index.jsp");
			return;
		}
		
		//JsonResult result = service.detail(merchant);
		/*System.out.println(result);
		if(result.isStatus()) {
			Map map = (Map)result.getData("merchantDetail");
			MerchantDetail detail = (MerchantDetail) BeanUtil.mapToBean(map, MerchantDetail.class);
			if(detail.getStatus() == 1) {
				IShopService shopService = new ShopServiceImpl();
				Shop shop = new Shop();
				shop.setMerchant_id(detail.getMerchantID());
				System.out.println(shop.getMerchant_id());
				Shop shop2 = shopService.find(shop);
				System.out.println(shop2);
				request.getSession().setAttribute("shop", shop2);
			}
			List<String> pics = (List<String>) map.get("shopPic");
			request.getSession().setAttribute("merchantDetail", detail);
			request.setAttribute("detail", detail);
		}
		request.getRequestDispatcher("/WEB-INF/jsp/merchant.jsp").forward(request, response);
		service.detail(merchant);*/
	}
}

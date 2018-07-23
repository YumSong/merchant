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
import com.lames.merchant.po.MerchantDetail;
import com.lames.merchant.service.IMerchantService;
import com.lames.merchant.service.impl.MerchantServiceImpl;
import com.lames.merchant.util.BeanUtil;
import com.lames.merchant.util.JsonUtil;


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
		}
		response.getWriter().write(JsonUtil.objectToJson(result));
	}
	
	@Mapping("/register")
	public void register(Merchant merchant,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		JsonResult result = service.register(merchant);
		if(result.isStatus()) {
			Merchant loginMerChant = (Merchant) BeanUtil.mapToBean((Map)result.getData("merchant"),Merchant.class);
			request.getSession().setAttribute("merchant", loginMerChant);
		}
		response.getWriter().write(JsonUtil.objectToJson(result));
	}
	
	
	@Mapping("/detail")
	public void detail(HttpSession session, HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		Merchant merchant = (Merchant) session.getAttribute("merchant");
		
		if(merchant == null || merchant.getMerchantID() == null) {
			response.sendRedirect(request.getServletPath() + "/login.jsp");
			return;
		}
		
		service.detail(merchant);

		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		
	}
}

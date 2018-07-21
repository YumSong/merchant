package com.lames.merchant.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
}

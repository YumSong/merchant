package com.lames.merchant.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.lames.merchant.config.Config;
import com.lames.merchant.config.WebServiceConfig;
import com.lames.merchant.model.JsonResult;
import com.lames.merchant.model.Merchant;
import com.lames.merchant.model.MerchantDetail;
import com.lames.merchant.model.Shop;
import com.lames.merchant.service.IMerchantService;
import com.lames.merchant.service.impl.MerchantServiceImpl;
import com.lames.merchant.util.BeanUtil;
import com.lames.merchant.util.WebConnection;

/**
 * Servlet implementation class MerchantServlet
 */
@WebServlet("/merchant/*")
public class MerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IMerchantService service = new MerchantServiceImpl();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getRequestURI();
		int start = url.lastIndexOf("/");
		int end = url.indexOf("?");
		String action = url;
		if(start > 0) {
			if(end > 0) {
				action = url.substring(start + 1, end);
			}else {
				action = url.substring(start + 1);
			}
		}
		if("login".equals(action)) {
			doLogin(request, response);
		}else if("register".equals(action)){
			doRegister(request, response);
		}else if("detail".equals(action)){
			doDetail(request, response);
		}
	}

	public void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Merchant merchant = (Merchant) BeanUtil.mapToBean(request.getParameterMap(),Merchant.class);
		JsonResult result = service.login(merchant);
		if(result.isStatus()) {
			Merchant loginMerChant = (Merchant) BeanUtil.mapToBean((Map)result.getData("merchant"),Merchant.class);
			request.getSession().setAttribute("merchant", loginMerChant);
			response.sendRedirect(request.getContextPath() + "/merchant/detail");
		}else {
			request.setAttribute("error", result.getMessage());
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
	
	public void doRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Merchant merchant = (Merchant) BeanUtil.mapToBean(request.getParameterMap(),Merchant.class);
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
	
	public void doDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Merchant merchant = (Merchant) request.getSession().getAttribute("merchant");
		if(merchant == null || merchant.getMerchantID() == null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		JsonResult result = service.detail(merchant);
		System.out.println(result);
		if(result.isStatus()) {
			Map map = (Map)result.getData("merchantDetail");
			MerchantDetail detail = (MerchantDetail) BeanUtil.mapToBean(map, MerchantDetail.class);
			
			String shopPicStr = (String) map.get("shopPic");
			detail.setShopPic(shopPicStr.split(";;"));
			
			request.setAttribute("detail", detail);
			//request.setAttribute("shop", shop);
		}
		request.getRequestDispatcher("/WEB-INF/jsp/merchant.jsp").forward(request, response);
		service.detail(merchant);
	}
}

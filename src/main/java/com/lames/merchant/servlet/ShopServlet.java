package com.lames.merchant.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.lames.merchant.config.WebServiceConfig;
import com.lames.merchant.model.JsonResult;
import com.lames.merchant.model.Merchant;
import com.lames.merchant.model.MerchantDetail;
import com.lames.merchant.model.Shop;
import com.lames.merchant.service.IShopService;
import com.lames.merchant.service.impl.ShopServiceImpl;
import com.lames.merchant.util.BeanUtil;
import com.lames.merchant.util.JsonUtil;
import com.lames.merchant.util.WebConnection;

import oracle.net.aso.a;


@MultipartConfig
@WebServlet("/shop/*")
public class ShopServlet extends HttpServlet{
	
	private IShopService service = new ShopServiceImpl();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
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
		if("new".equals(action)) {
			doNew(req, resp);
		}else if("apply".equals(action)) {
			doApply(req, resp);
		}else if("update".equals(action)) {
			doUpdate(req, resp);
		}
	}
	
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	private void doNew(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
	}
	
	private void doApply(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		
		MerchantDetail detail = (MerchantDetail) BeanUtil.mapToBean(request.getParameterMap(), MerchantDetail.class);
		Shop reqShop = (Shop) BeanUtil.mapToBean(request.getParameterMap(), Shop.class);
		
		//set reqShop
		reqShop.setService_starttime(new Timestamp(Long.parseLong(request.getParameter("service_starttime"))));
		reqShop.setService_endtime(new Timestamp(Long.parseLong(request.getParameter("service_endtime"))));
		reqShop.setService_range(Integer.parseInt(request.getParameter("service_range")));
		reqShop.setDistribution_cost(Double.parseDouble(request.getParameter("distribution_cost")));
		
		System.out.println(reqShop);
		detail.setIdcardNum(Integer.parseInt(request.getParameter("idcardNum")));
		Merchant merchant = (Merchant) request.getSession().getAttribute("merchant");
		
		if(merchant == null || merchant.getLoginName() == null || merchant.getMerchantID() == null) {
			resp.sendRedirect(request.getContextPath()+ "/index.jsp");
			return;
		}
		//set detail 
		detail.setMerchantID(merchant.getMerchantID());
		//upload image
		String server = WebServiceConfig.getConfig().get("image.upload");
		List<String> shopPics = new ArrayList<>();
		
		for(Part part : request.getParts()) {
			if(part.getContentType() == null) {
				continue;
			}
			
			String name = part.getName();
			
			WebConnection conn = new WebConnection(server);
			
			conn.setHeader("content-type", WebConnection.MUTIPART);
			conn.addFile("idcardPic", part);
			String jsonStr = conn.post();
			
			JsonResult result = (JsonResult) JsonUtil.jsonToObject(jsonStr, JsonResult.class);
			if(result.isStatus()) {
				String url = (String) result.getData("url");
				if("idcardPic".equals(name)) {
					detail.setIdcardPic(url);
				}else if("shopPic".equals(name)) {
					shopPics.add(url);
				}else if("businessPic".equals(name)){
					detail.setBusinessPic(url);
				}
			}
			detail.setShopPic(shopPics);
		}
		
		reqShop.setBusiness_pic(detail.getBusinessPic());
		reqShop.setShop_pic(shopPics.size() > 0 ? shopPics.get(0) : null);
		
		//check update or insert
		MerchantDetail merchantDetail = (MerchantDetail) request.getSession().getAttribute("merchantDetail");
		if(merchantDetail != null) {
			detail.setShopID(merchantDetail.getShopID());
			detail.setMerchantDetailID(merchantDetail.getMerchantDetailID());
		}
		System.out.println(reqShop);
		Shop shop = service.apply(detail,reqShop);
		
		if(shop != null) {
			//request.getRequestDispatcher("/merchant/detail").forward(request, resp);
			resp.sendRedirect(request.getContextPath() + "/merchant/detail");
		}else {
			resp.sendRedirect(request.getContextPath() + "/merchant/new");
		}
	}
	
	private void doUpdate(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		MerchantDetail merchantDetail = (MerchantDetail) request.getSession().getAttribute("merchantDetail");
		if(merchantDetail == null) {
			resp.sendRedirect(request.getContextPath() + "/merchant/detail");
		}else {
			request.getRequestDispatcher("/WEB-INF/jsp/shop_form.jsp").forward(request, resp);
		}
	}
}

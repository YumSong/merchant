package com.lames.merchant.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jake.model.Merchant;
import com.jake.webmvc.annotation.Controller;
import com.jake.webmvc.annotation.Mapping;
import com.lames.merchant.po.Recipe;
import com.lames.merchant.service.IRecipeService;
import com.lames.merchant.service.impl.RecipeServiceImpl;

@Controller
@Mapping("/recipe")
public class RecipeController {
	
	private IRecipeService service = new RecipeServiceImpl();
	
	@Mapping("/add")
	public void addRecipe(Recipe recipe,HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(recipe);
		Merchant merchant = (Merchant) session.getAttribute("merchant");
		if(merchant == null) {
			response.sendRedirect("index.jsp");
		}
//		request.setCharacterEncoding("UTF-8");
//		
//		// get pictrue url
//		Config config = WebServiceConfig.getConfig();
//		WebConnection conn = new WebConnection(config.get("image.upload"));
//		conn.setHeader("content-type", WebConnection.MUTIPART);
//		conn.addFile("re_pic", pic_part);
//		// post picture to resoucrce server.
//		String re_pic = conn.post();
//		
//		JsonResult pic_result = (JsonResult) JsonUtil.jsonToObject(re_pic, JsonResult.class);
//		System.out.println("Hello");
//		if(pic_result.isStatus()) {
//			re_pic = (String) pic_result.getData().get("url");
//		}else {
//			System.out.println("暂不处理");
//		}
//		
//		// create a instance of Recipe
//		Recipe recipe = new Recipe(re_name, re_pic, detail, Double.parseDouble(price), Integer.parseInt(shop_id));
//		
//		// servcie: insert db
//		service.insert(recipe);
//		
////		request.getRequestDispatcher("/recipe/get").forward(request, response);
//		request.getRequestDispatcher("getRecipe.do").forward(request, response);
////		response.sendRedirect(request.getContextPath() + "/recipe/get");
	}
}

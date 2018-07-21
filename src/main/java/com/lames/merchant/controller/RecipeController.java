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
		// 获取商户登陆状态
		Merchant merchant = (Merchant) session.getAttribute("merchant");
		if(merchant == null || merchant.getMerchantID() == null) {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			return;
		}
		
		
		// 获取商店经营状态
		
		
		
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
	
	@Mapping("/delete")
	public void deleteRecipe(Recipe recipe,HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Recipe recipe = new Recipe();
//		recipe.setRe_id(re_id);
//		recipe.setShop_id(shop_id);
//		service.delete(recipe);
//		request.getRequestDispatcher("getRecipe.do").forward(request, response);
	}	
	
	@Mapping("/get")
	public void getRecipe(Recipe recipe,HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		Shop shop = (Shop) session.getAttribute("shop");
//		System.out.println(shop);
//		if(shop != null) {
//			session.setAttribute("shop_id", shop.getShop_id());
//			Integer shop_id = (Integer) session.getAttribute("shop_id");
//			List<Recipe> recipeList = service.findAll(shop_id);
//			request.setAttribute("recipeList", recipeList);
//			request.getRequestDispatcher("listRecipe.jsp").forward(request, response);
//		}else {
//			response.sendRedirect(request.getContextPath() + "/merchant/detail");
//		}
//	response.sendRedirect(request.getContextPath() + "/"  + "addRecipe.jsp");
	}	
	
	@Mapping("/getAll")
	protected void getAllRecipe(Recipe recipe,HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Integer re_id = Integer.parseInt(request.getParameter("re_id"));
//		Recipe recipe = new Recipe();
//		recipe.setRe_id(re_id);
//		Recipe recipe1 = service.find(recipe);
//		request.setAttribute("recipe", recipe1);
//		request.getRequestDispatcher("modifyRecipe.jsp").forward(request, response);
	}	
}

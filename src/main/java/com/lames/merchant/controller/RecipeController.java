package com.lames.merchant.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jake.webmvc.annotation.Controller;
import com.jake.webmvc.annotation.Mapping;
import com.lames.merchant.model.JsonResult;
import com.lames.merchant.po.Merchant;
import com.lames.merchant.po.Recipe;
import com.lames.merchant.service.newVersion.IRecipeService;
import com.lames.merchant.service.newVersion.impl.RecipeServiceImpl;
import com.lames.merchant.util.JsonUtil;

@Controller
@Mapping("/recipe")
public class RecipeController {
	
	private IRecipeService service = new RecipeServiceImpl();
	
	@Mapping("/save")
	public void addRecipe(Recipe recipe,HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(recipe);		
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		JsonResult result = new JsonResult();
		if(service.saveRecipe(recipe) != null) {
			result.setStatus(true);
			result.setData("recipe", recipe);
			System.out.println(recipe);
			result.setMessage("添加成功!");
		}else {
			result.setStatus(false);
			result.setMessage("添加失败!");
		}
		writer.write(JsonUtil.objectToJson(result));		
//		Merchant merchant = (Merchant) session.getAttribute("merchant");
//		if(merchant == null) {
//			response.sendRedirect("index.jsp");
//		}
	}
	
	@Mapping("/delete")
	public void deleteRecipe(Recipe recipe,HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(recipe);		
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		JsonResult result = new JsonResult();
		if(service.deleteByRecipeId(recipe) != null) {
			result.setStatus(true);
			result.setMessage("删除成功!");
		}else {
			result.setStatus(false);
			result.setMessage("删除失败!");
		}
		writer.write(JsonUtil.objectToJson(result));		
	}	
	
	@Mapping("/modify")
	public void modifyRecipe(Recipe recipe,HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(recipe);		
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		JsonResult result = new JsonResult();
		if(service.modifyRecipe(recipe) != null) {
			result.setStatus(true);
			result.setMessage("修改成功!");
		}else {
			result.setStatus(false);
			result.setMessage("修改失败!");
		}
		writer.write(JsonUtil.objectToJson(result));		
	}
	
	@Mapping("/list")
	public void listRecipe(Recipe recipe,HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(recipe);		
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		JsonResult result = new JsonResult();
		if(service.findByRecipe(recipe) != null) {
			result.setStatus(true);
			result.setMessage("查找成功!");
		}else {
			result.setStatus(false);
			result.setMessage("查找失败!");
		}
		writer.write(JsonUtil.objectToJson(result));		
	}
	
	@Mapping("/listAll")
	public void listAllRecipe(Recipe recipe, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = response.getWriter();
		JsonResult result = new JsonResult();
		List<Recipe> recipeList = service.findAllByShopId(recipe);
		if(recipeList != null && !recipeList.isEmpty()) {
			result.setStatus(true);
			result.setMessage("成功找到菜!");
		}else {
			result.setStatus(false);
			result.setMessage("抱歉，您还没有菜!");
		}
		writer.write(JsonUtil.objectToJson(result));		
	}	
}

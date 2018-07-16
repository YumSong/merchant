package com.lames.merchant.servlet;

import java.io.IOException;
import java.util.List;

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
import com.lames.merchant.model.Recipe;
import com.lames.merchant.service.IRecipeService;
import com.lames.merchant.service.impl.RecipeServiceImpl;
import com.lames.merchant.util.JsonUtil;
import com.lames.merchant.util.WebConnection;

/**
 * Servlet implementation class RecipeServlet
 */
@WebServlet("/recipe/*")
@MultipartConfig
public class RecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IRecipeService service = new RecipeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getRequestURI());
		if("/merchant/recipe/del".equals(request.getRequestURI())) {
			doDelete(request, response);
		}else if("/merchant/recipe/mod".equals(request.getRequestURI())){
			doPut(request, response);
		}else if("/merchant/recipe/add".equals(request.getRequestURI())){
			// get parameters
			String shop_id = request.getParameter("shop_id");
			String re_name = request.getParameter("re_name");
			String detail = request.getParameter("detail");
			String price = request.getParameter("price");
			Part pic_part = request.getPart("re_pic");
			
			// get pictrue url
			Config config = WebServiceConfig.getConfig();
			WebConnection conn = new WebConnection(config.get("image.upload"));
			conn.setHeader("content-type", WebConnection.MUTIPART);
			conn.addFile("re_pic", pic_part);
			// post picture to resoucrce server.
			String re_pic = conn.post();
			
			JsonResult pic_result = (JsonResult) JsonUtil.jsonToObject(re_pic, JsonResult.class);
			System.out.println("Hello");
			if(pic_result.isStatus()) {
				re_pic = (String) pic_result.getData().get("url");
			}else {
				System.out.println("暂不处理");
			}
			
			// create a instance of Recipe
			Recipe recipe = new Recipe(re_name, re_pic, detail, Double.parseDouble(price), Integer.parseInt(shop_id));
			
			// servcie: insert db
			service.insert(recipe);
			
//			request.getRequestDispatcher("/recipe/get").forward(request, response);
			request.getRequestDispatcher("recipe.jsp").forward(request, response);
			response.sendRedirect(request.getContextPath() + "/recipe/get");
		}
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			List<Recipe> recipeList = service.findAll();
			request.setAttribute("recipeList", recipeList);
			request.getRequestDispatcher("/recipe.jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath() + "/"  + "addRecipe.jsp");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
}

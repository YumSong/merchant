package com.lames.merchant.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
 * Servlet implementation class SubmitModifyRecipeServlet
 */
//multipart config一定要配置
@MultipartConfig
public class SubmitModifyRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private IRecipeService service = new RecipeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitModifyRecipeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get parameters
		String re_id = request.getParameter("re_id");
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
		if(pic_result.isStatus()) {
			re_pic = (String) pic_result.getData().get("url");
		}else {
			System.out.println("暂不处理");
		}
		
		// create a instance of Recipe
		Recipe recipe = new Recipe(re_name, re_pic, detail, Double.parseDouble(price));
		recipe.setRe_id(Integer.parseInt(re_id));
		
		// servcie: modify db
		service.modify(recipe);
		
		request.getRequestDispatcher("getRecipe.do").forward(request, response);
	}

}

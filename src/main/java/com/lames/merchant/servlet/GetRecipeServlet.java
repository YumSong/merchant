package com.lames.merchant.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lames.merchant.model.Recipe;
import com.lames.merchant.model.Shop;
import com.lames.merchant.service.IRecipeService;
import com.lames.merchant.service.impl.RecipeServiceImpl;

/**
 * Servlet implementation class GetRecipeServlet
 */
public class GetRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private IRecipeService service = new RecipeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRecipeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Shop shop = (Shop) session.getAttribute("shop");
		System.out.println(shop);
		if(shop != null) {
			session.setAttribute("shop_id", shop.getShop_id());
			Integer shop_id = (Integer) session.getAttribute("shop_id");
			List<Recipe> recipeList = service.findAll(shop_id);
			request.setAttribute("recipeList", recipeList);
			request.getRequestDispatcher("listRecipe.jsp").forward(request, response);
		}else {
			response.sendRedirect(request.getContextPath() + "/merchant/detail");
		}
//	response.sendRedirect(request.getContextPath() + "/"  + "addRecipe.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

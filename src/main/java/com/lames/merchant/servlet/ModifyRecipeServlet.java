package com.lames.merchant.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lames.merchant.model.Recipe;
import com.lames.merchant.service.IRecipeService;
import com.lames.merchant.service.impl.RecipeServiceImpl;

/**
 * Servlet implementation class ModifyRecipeServlet
 */
public class ModifyRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private IRecipeService service = new RecipeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyRecipeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer re_id = Integer.parseInt(request.getParameter("re_id"));
		Recipe recipe = new Recipe();
		recipe.setRe_id(re_id);
		Recipe recipe1 = service.find(recipe);
		request.setAttribute("recipe", recipe1);
		request.getRequestDispatcher("modifyRecipe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

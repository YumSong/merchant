package com.lames.merchant.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.lames.merchant.util.WebConnection;

/**
 * Servlet implementation class MerchantServlet
 */
@WebServlet("/merchant")
@MultipartConfig
public class MerchantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Part> parts = (List<Part>) request.getParts();
		WebConnection conn = new WebConnection("http://localhost:4444/picServer/upload");
		conn.setHeader("content-type", request.getContentType());
		conn.setHeader("content-length", request.getContentLength() + "");
		conn.setHeader("parts", request.getParts().size() + "");
		for(Part part : parts) {
			conn.addFile(part.getName(), part);
		}
		String str = conn.post();
		System.out.println(str);
	}

}

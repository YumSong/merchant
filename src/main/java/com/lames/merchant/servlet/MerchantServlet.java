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
		
		/*InputStream is = request.getInputStream();
		byte[] buf = new byte[1024];
		int len = 0;
		StringBuilder sb = new StringBuilder();
		while((len = is.read(buf)) != -1) {
			sb.append(new String(buf,0,len));
		}
		System.out.println(sb.toString());
		Enumeration<String> enumeration = request.getHeaderNames();
		while (enumeration.hasMoreElements()) {
			String str = (String) enumeration.nextElement();
			System.out.println(str + ":" + request.getHeader(str));
		}*/
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

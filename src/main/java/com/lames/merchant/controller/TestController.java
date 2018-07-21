package com.lames.merchant.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import com.jake.webmvc.annotation.Controller;
import com.jake.webmvc.annotation.Mapping;

@Controller
public class TestController {

	
	@Mapping("/test")
	public void test(HttpServletResponse res,String id) throws IOException {
	}
}

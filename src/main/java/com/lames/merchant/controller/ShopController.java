package com.lames.merchant.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jake.ValidatorExecutor;
import com.jake.webmvc.annotation.Controller;
import com.jake.webmvc.annotation.Mapping;
import com.lames.merchant.model.JsonResult;
import com.lames.merchant.po.MerchantDetail;
import com.lames.merchant.util.JsonUtil;

@Controller
@Mapping("/shop")
public class ShopController {
	
	@Mapping("/apply")
	public void apply(MerchantDetail detail,HttpServletResponse response) throws IOException {
		System.out.println(detail);
		List<com.jake.model.Error> errors = ValidatorExecutor.validate(detail);
		JsonResult jsonResult = new JsonResult();
		if(errors.size() > 0) {
			jsonResult.setStatus(false);
			jsonResult.setData("errors", errors);
		}
		
		response.getWriter().write(JsonUtil.objectToJson(jsonResult));
	}
}

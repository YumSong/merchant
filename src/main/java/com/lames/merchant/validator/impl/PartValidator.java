package com.lames.merchant.validator.impl;

import java.util.Map;

import javax.servlet.http.Part;

import com.lames.merchant.validator.IValidator;

public class PartValidator implements IValidator<Part> {

	@Override
	public Map<String, String> validate(String fieldName, Part fieldValue) {
		
		return null;
	}

}

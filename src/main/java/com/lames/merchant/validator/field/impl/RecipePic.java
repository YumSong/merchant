package com.lames.merchant.validator.field.impl;

import java.util.Map;

import javax.servlet.http.Part;

import com.lames.merchant.validator.IValidator;
import com.lames.merchant.validator.basic.impl.PartNotNullValidator;

public class RecipePic implements IValidator<Part> {

	@Override
	public Map<String, String> validate(String fieldName, Part fieldValue) {
		Map<String, String> errs = new PartNotNullValidator(null).validate(fieldName, fieldValue);
		return errs;
	}

}

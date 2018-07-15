package com.lames.merchant.validator.basic.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Part;

import com.lames.merchant.validator.IValidator;

public class PartNotNullValidator implements IValidator<Part> {
	private final String NOT_NULL = "%s can not be empty";
	private IValidator<Part> validator;
	
	public PartNotNullValidator(IValidator<Part> validator) {
		this.validator = validator;
	}

	@Override
	public Map<String, String> validate(String fieldName, Part fieldValue) {
		Map<String, String> errs = new HashMap<String, String>();
		if(fieldValue.getSize() == 0) {
			errs.put(fieldName, String.format(NOT_NULL, fieldName));
			return errs;
		}
		if(validator != null) {
			errs.putAll(validator.validate(fieldName, fieldValue));
		}
		return errs;
	}
}

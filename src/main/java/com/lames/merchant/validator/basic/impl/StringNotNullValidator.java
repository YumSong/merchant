package com.lames.merchant.validator.basic.impl;

import java.util.HashMap;
import java.util.Map;

import com.lames.merchant.validator.IValidator;

public class StringNotNullValidator implements IValidator<String>{
	private final String NOT_NULL = "%s can not be empty";
	private IValidator<String> validator;
	
	public StringNotNullValidator(IValidator<String> validator) {
		this.validator = validator;
	}

	@Override
	public Map<String, String> validate(String fieldName, String fieldValue) {
		Map<String, String> errs = new HashMap<String, String>();
		if(fieldValue == null) {
			errs.put(fieldName, String.format(NOT_NULL, fieldName));
			return errs;
		}
		if(validator != null) {
			errs.putAll(validator.validate(fieldName, fieldValue));
		}
		return errs;
	}
}

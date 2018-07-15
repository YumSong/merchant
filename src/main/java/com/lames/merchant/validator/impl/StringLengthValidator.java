package com.lames.merchant.validator.impl;

import java.util.HashMap;
import java.util.Map;

import com.lames.merchant.validator.IValidator;

public class StringLengthValidator implements IValidator<String> {
	private final String STRING_LENGTH_ERR = "%s can not less 10 char";
	private final Integer DEFAULT_LENGTH = 10;
	
	
	@Override
	public Map<String, String> validate(String fieldName, String fieldValue) {
		Map<String, String> errs = new HashMap<String, String>();
		if(fieldValue.length() < DEFAULT_LENGTH) {
			errs.put(fieldName, String.format(STRING_LENGTH_ERR, fieldName));
		}
		return errs;
	}
}

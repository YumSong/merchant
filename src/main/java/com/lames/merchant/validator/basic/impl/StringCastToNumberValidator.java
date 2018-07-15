package com.lames.merchant.validator.basic.impl;

import java.util.HashMap;
import java.util.Map;

import com.lames.merchant.validator.IValidator;

public class StringCastToNumberValidator implements IValidator<String> {
	private final String STRING_CAST_TO_INTEGER_ERR = "%s must be number";
	private IValidator<String> validator;
	
	public StringCastToNumberValidator() {}
	
	public StringCastToNumberValidator(IValidator<String> validator) {
		this.validator = validator;
	}	
	
	@Override
	public Map<String, String> validate(String fieldName, String fieldValue) {
		Map<String, String> errs = new HashMap<String, String>();
		try {
			Double.parseDouble(fieldValue);
			if(validator != null) {
				errs.putAll(validator.validate(fieldName, fieldValue));
			}
		} catch(Exception e) {
			errs.put(fieldName, String.format(STRING_CAST_TO_INTEGER_ERR, fieldName));
			return errs;
		}
		return errs;
	}

}

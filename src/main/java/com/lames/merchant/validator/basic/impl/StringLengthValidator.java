package com.lames.merchant.validator.basic.impl;

import java.util.HashMap;
import java.util.Map;

import com.lames.merchant.validator.IValidator;

public class StringLengthValidator implements IValidator<String> {
	private final String STRING_LENGTH_ERR = "%s can not less than %d and %d character";
	private Integer less_length;
	private Integer geater_length;
	
	private IValidator<String> validator;
	
	public StringLengthValidator(IValidator<String> validator) {
		this.validator = validator;
	}

	
	public StringLengthValidator(Integer less_length, Integer geater_length) {
		this.less_length = less_length;
		this.geater_length = geater_length;
	}

	@Override
	public Map<String, String> validate(String fieldName, String fieldValue) {
		Map<String, String> errs = new HashMap<String, String>();
		if (fieldValue.length() >= less_length && fieldValue.length() <= geater_length) {
			errs.put(fieldName, String.format(STRING_LENGTH_ERR, fieldName, less_length, geater_length));
			return errs;
		}
		if(validator != null) {
			errs.putAll(validator.validate(fieldName, fieldValue));
		}
		return errs;
	}
}

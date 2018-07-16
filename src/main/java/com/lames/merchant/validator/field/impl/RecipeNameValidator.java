package com.lames.merchant.validator.field.impl;

import java.util.Map;

import com.lames.merchant.validator.IValidator;
import com.lames.merchant.validator.basic.impl.StringLengthValidator;
import com.lames.merchant.validator.basic.impl.StringNotNullValidator;

public class RecipeNameValidator implements IValidator<String> {

	@Override
	public Map<String, String> validate(String fieldName, String fieldValue) {
		Map<String, String> errs = new StringNotNullValidator(new StringLengthValidator(5, 10)).validate(fieldName, fieldValue);
		return errs;
	}

}

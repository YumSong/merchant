package com.lames.merchant.validator;

import java.util.Map;

public interface IValidator<T> {
	public Map<String, String> validate (String fieldName, T fieldValue);
}

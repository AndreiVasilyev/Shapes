package by.epam.jwdshape.validator.impl;

import by.epam.jwdshape.validator.ConeStringValidator;

public class ConeStringValidatorImpl implements ConeStringValidator {

	private final String VALID_CONE_PARAMS_REGEX = "^(-?\\d+(\\.\\d{1,2})?\\s+){3}(\\d+(\\.\\d{1,2})?\\s+)(\\d+(\\.\\d{1,2})?)$";

	public boolean isConeStringValid(String line) {
		String trimedString = line.trim();
		boolean result = trimedString.matches(VALID_CONE_PARAMS_REGEX);
		return result;
	}
}

package by.epam.jwdshape.validator.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.jwdshape.validator.ConeParametersValidator;

public class ConeParametersValidatorImpl implements ConeParametersValidator {

	private static final Logger log = LogManager.getLogger();
	private final double COORDINATE_VALUE_RANGE = 1000;

	public boolean isConeParamValid(double x, double y, double z, double radius, double height) {

		if (Math.abs(x) > COORDINATE_VALUE_RANGE || Math.abs(y) > COORDINATE_VALUE_RANGE
				|| Math.abs(z) > COORDINATE_VALUE_RANGE) {
			log.warn("Not validated. Wrong coordinate of cone.");
			return false;
		}

		if (radius <= 0 || height <= 0) {
			log.warn("Not validated. Wrong radius or height value.");
			return false;
		}
		
		return true;
	}

	public boolean isConeParamValid(double[] params) {

		return isConeParamValid(params[0], params[1], params[2], params[3], params[4]);
	}

	@Override
	public boolean isCutConeHeightValid(double cutConeHeight) {
		// TODO Auto-generated method stub
		return false;
	}

}

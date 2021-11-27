package by.epam.jwdshape.validator.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.jwdshape.validator.ConeParametersValidator;

public class ConeParametersValidatorImpl implements ConeParametersValidator {

	private static final Logger log = LogManager.getLogger();
	private final double COORDINATE_VALUE_RANGE = 1000;
	private final int PARAMS_ARRAY_SIZE = 5;

	public boolean isConeParamValid(double x, double y, double z, double radius, double height) {

		if (Math.abs(x) > COORDINATE_VALUE_RANGE || Math.abs(y) > COORDINATE_VALUE_RANGE
				|| Math.abs(z) > COORDINATE_VALUE_RANGE) {
			log.warn("Not validated. Wrong coordinate of cone({},{},{})", x, y, z);
			return false;
		}

		if (radius <= 0 || height <= 0) {
			log.warn("Not validated. Wrong radius {} or height value {}", radius, height);
			return false;
		}

		return true;
	}

	public boolean isConeParamValid(double[] params) {

		if (params == null || params.length != PARAMS_ARRAY_SIZE) {
			log.warn("Not validated. Wrong params array valus or size {}", params);
			return false;
		}

		return isConeParamValid(params[0], params[1], params[2], params[3], params[4]);
	}

	@Override
	public boolean isCutConeHeightValid(double cutConeHeight, double coneHeight) {

		if (cutConeHeight > 0 && cutConeHeight < coneHeight) {
			return true;
		}
		log.warn("Not validated. Wrong cutConeHeight {} in cone with height {}", cutConeHeight, coneHeight);
		return false;
	}

}

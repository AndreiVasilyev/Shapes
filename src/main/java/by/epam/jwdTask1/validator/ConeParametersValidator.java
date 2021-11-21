package by.epam.jwdTask1.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConeParametersValidator {

	private final static Logger log = LogManager.getLogger();
	private static final double COORDINATE_MAX_VALUE = 1000;

	public static boolean isConeParamValid(double x, double y, double z, double radius, double height) {

		if (Math.abs(x) > COORDINATE_MAX_VALUE || Math.abs(y) > COORDINATE_MAX_VALUE
				|| Math.abs(z) > COORDINATE_MAX_VALUE) {
			log.warn("Not validated. Wrong coordinate of cone.");
			return false;
		}

		if (radius <= 0 || height <= 0) {
			log.warn("Not validated. Wrong radius or height value");
			return false;
		}

		return true;
	}

	public static boolean isConeParamValid(double[] params) {

		return isConeParamValid(params[0], params[1], params[2], params[3], params[4]);
	}

}

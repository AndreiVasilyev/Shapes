package by.epam.jwdshape.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.jwdshape.entity.Cone;
import by.epam.jwdshape.entity.Point;
import by.epam.jwdshape.exception.ConeException;
import by.epam.jwdshape.validator.ConeParametersValidator;
import by.epam.jwdshape.validator.impl.ConeParametersValidatorImpl;

public class ConeFactory {

	private static final Logger log = LogManager.getLogger();

	public static Cone create(double[] params) throws ConeException {

		ConeParametersValidator validator = new ConeParametersValidatorImpl();
		if (!validator.isConeParamValid(params)) {
			log.error("Wrong parameters when creating new Cone");
			throw new ConeException("Wrong parameters when creating new Cone");
		}

		Point point = new Point(params[0], params[1], params[2]);
		Cone cone = new Cone(point, params[3], params[4]);
		log.info("New Cone created successfully");
		return cone;

	}

	public static Cone create(double x, double y, double z, double radius, double height) throws ConeException {

		ConeParametersValidator validator = new ConeParametersValidatorImpl();
		if (!validator.isConeParamValid(x, y, z, radius, height)) {
			log.error("Wrong parameters when creating new Cone");
			throw new ConeException("Wrong parameters when creating new Cone");
		}

		Point point = new Point(x, y, z);
		Cone cone = new Cone(point, radius, height);
		log.info("New Cone created successfully");
		return cone;
	}

	public static Cone create(Point point, double radius, double height) throws ConeException {

		ConeParametersValidator validator = new ConeParametersValidatorImpl();
		if (!validator.isConeParamValid(point.getX(), point.getY(), point.getZ(), radius, height)) {
			log.error("Wrong parameters when creating new Cone");
			throw new ConeException("Wrong parameters when creating new Cone");
		}

		Cone cone = new Cone(point, radius, height);
		log.info("New Cone created successfully");
		return cone;
	}

}

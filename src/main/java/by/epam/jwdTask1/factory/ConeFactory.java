package by.epam.jwdTask1.factory;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.jwdTask1.entity.Cone;
import by.epam.jwdTask1.entity.Point;
import by.epam.jwdTask1.exception.ConeException;
import by.epam.jwdTask1.validator.ConeParametersValidator;

public class ConeFactory {

	private final static Logger log = LogManager.getLogger();

	// TODO which is better - to repeat the code or call one method

	public static Cone create(double[] params) throws ConeException {

		if (!ConeParametersValidator.isConeParamValid(params)) {
			log.error("Wrong parameters when creating new Cone");
			throw new ConeException("Wrong parameters when creating new Cone");
		}

		Point point = new Point(params[0], params[1], params[2]);
		Cone cone = new Cone(point, params[3], params[4]);
		log.info("New Cone created successfully");
		return cone;

	}

	public static Cone create(double x, double y, double z, double radius, double height) throws ConeException {

		if (!ConeParametersValidator.isConeParamValid(x, y, z, radius, height)) {
			log.error("Wrong parameters when creating new Cone");
			throw new ConeException("Wrong parameters when creating new Cone");
		}

		Point point = new Point(x, y, z);
		Cone cone = new Cone(point, radius, height);
		log.info("New Cone created successfully");
		return cone;
	}

	public static Cone create(Point point, double radius, double height) throws ConeException {

		if (!ConeParametersValidator.isConeParamValid(point.getX(), point.getY(), point.getZ(), radius, height)) {
			log.error("Wrong parameters when creating new Cone");
			throw new ConeException("Wrong parameters when creating new Cone");
		}
		Cone cone = new Cone(point, radius, height);
		log.info("New Cone created successfully");
		return cone;
	}

}

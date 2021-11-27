package by.epam.jwdshape.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.jwdshape.entity.Cone;
import by.epam.jwdshape.entity.Point;
import by.epam.jwdshape.exception.ConeException;
import by.epam.jwdshape.service.ConeService;
import by.epam.jwdshape.validator.ConeParametersValidator;
import by.epam.jwdshape.validator.impl.ConeParametersValidatorImpl;

public class ConeServiceImpl implements ConeService {

	private static final Logger log = LogManager.getLogger();

	@Override
	public double calculateSurfaceArea(Cone cone) throws ConeException {

		if (!isCone(cone.getCenter(), cone.getRadius(), cone.getHeight())) {
			log.error("Wrong cone params when calculate surface area");
			throw new ConeException("Wrong cone params when calculate surface area");
		}
		double radius = cone.getRadius();
		double height = cone.getHeight();
		return Math.PI * radius * (radius + Math.sqrt(radius * radius + height * height));
	}

	@Override
	public double calculateVolume(Cone cone) throws ConeException {

		if (!isCone(cone.getCenter(), cone.getRadius(), cone.getHeight())) {
			log.error("Wrong cone params when calculate volume");
			throw new ConeException("Wrong cone params when calculate volume");
		}
		double radius = cone.getRadius();
		double height = cone.getHeight();
		return (Math.PI * height * radius * radius) / 3;
	}

	@Override
	public double CalculateCutConeVolumeRatio(Cone cone, double cutConeHeight) throws ConeException {

		if (!isCone(cone.getCenter(), cone.getRadius(), cone.getHeight())) {
			log.error("Wrong cone params when calculate cut cone volume ratio");
			throw new ConeException("Wrong cone params when calculate cut cone volume ratio");
		}

		ConeParametersValidator validator = new ConeParametersValidatorImpl();
		if (!validator.isCutConeHeightValid(cutConeHeight,cone.getHeight())) {
			log.error("Wrong cut cone height when calculate cut cone volume ratio");
			throw new ConeException("Wrong cut cone height when calculate cut cone volume ratio");
		}

		double mainConeVolume = calculateVolume(cone);
		double mainRadius = cone.getRadius();
		double mainHeight = cone.getHeight();
		double topConeRadius = mainRadius * (1 - (mainHeight - cutConeHeight) / mainHeight);
		double topConeVolume = (Math.PI * cutConeHeight * topConeRadius * topConeRadius) / 3;
		return mainConeVolume / topConeVolume;
	}

	@Override
	public boolean isBaseConeOnCoordinatePlane(Cone cone) throws ConeException {

		if (!isCone(cone.getCenter(), cone.getRadius(), cone.getHeight())) {
			log.error("Wrong cone params when check is base cone on coordinate plane");
			throw new ConeException("Wrong cone params when check is base cone on coordinate plane");
		}

		Point centerPoint = cone.getCenter();
		return centerPoint.getX() == 0 ? true : centerPoint.getY() == 0 ? true : centerPoint.getZ() == 0 ? true : false;
	}

	@Override
	public boolean isCone(Point point, double radius, double height) {
		ConeParametersValidator validator = new ConeParametersValidatorImpl();
		return validator.isConeParamValid(point.getX(), point.getY(), point.getZ(), radius, height);
	}

}

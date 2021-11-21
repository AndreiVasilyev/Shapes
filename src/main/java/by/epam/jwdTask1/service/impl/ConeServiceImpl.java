package by.epam.jwdTask1.service.impl;

import by.epam.jwdTask1.entity.Cone;
import by.epam.jwdTask1.entity.Point;
import by.epam.jwdTask1.service.ConeService;
import by.epam.jwdTask1.validator.ConeParametersValidator;

public class ConeServiceImpl implements ConeService {

	@Override
	public double calculateSurfaceArea(Cone cone) {
		double radius = cone.getRadius();
		double height = cone.getHeight();
		return Math.PI * radius * (radius + Math.sqrt(radius * radius + height * height));
	}

	@Override
	public double calculateVolume(Cone cone) {
		double radius = cone.getRadius();
		double height = cone.getHeight();
		return (Math.PI * height * radius * radius) / 3;
	}

	@Override
	public double CalculateCutConeVolumeRatio(Cone cone, double height) {
		double mainConeVolume = calculateVolume(cone);
		double mainRadius = cone.getRadius();
		double mainHeight = cone.getHeight();
		double topConeRadius = mainRadius * (1 - (mainHeight - height) / mainHeight);
		double topConeVolume = (Math.PI * height * topConeRadius * topConeRadius) / 3;
		return mainConeVolume / topConeVolume;
	}

	@Override
	public boolean isBaseConeOnCoordinatePlane(Cone cone) {
		Point centerPoint = cone.getCenter();
		return centerPoint.getX() == 0 ? true : centerPoint.getY() == 0 ? true : centerPoint.getZ() == 0 ? true : false;
	}

	@Override
	public boolean isCone(Point point, double radius, double height) {
		return ConeParametersValidator.isConeParamValid(point.getX(), point.getY(), point.getZ(), radius, height);
	}

}

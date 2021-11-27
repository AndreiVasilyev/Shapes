package by.epam.jwdshape.service;

import by.epam.jwdshape.entity.Cone;
import by.epam.jwdshape.entity.Point;
import by.epam.jwdshape.exception.ConeException;

public interface ConeService {

	double calculateSurfaceArea(Cone cone) throws ConeException;

	double calculateVolume(Cone cone) throws ConeException;

	double CalculateCutConeVolumeRatio(Cone cone, double height) throws ConeException;

	boolean isBaseConeOnCoordinatePlane(Cone cone) throws ConeException;

	boolean isCone(Point point, double radius, double height);
}

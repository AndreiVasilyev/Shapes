package by.epam.jwdshape.service;

import by.epam.jwdshape.entity.Cone;
import by.epam.jwdshape.entity.Point;
import by.epam.jwdshape.exception.ConeException;

public interface ConeService {

	public double calculateSurfaceArea(Cone cone) throws ConeException;

	public double calculateVolume(Cone cone) throws ConeException;

	public double CalculateCutConeVolumeRatio(Cone cone, double height) throws ConeException;

	public boolean isBaseConeOnCoordinatePlane(Cone cone) throws ConeException;

	public boolean isCone(Point point, double radius, double height);
}

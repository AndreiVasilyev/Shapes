package by.epam.jwdTask1.service;

import by.epam.jwdTask1.entity.Cone;
import by.epam.jwdTask1.entity.Point;

public interface ConeService {

	public double calculateSurfaceArea(Cone cone);

	public double calculateVolume(Cone cone);

	public double CalculateCutConeVolumeRatio(Cone cone, double height);

	public boolean isBaseConeOnCoordinatePlane(Cone cone);

	public boolean isCone(Point point, double radius, double height);
}

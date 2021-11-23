package by.epam.jwdshape.repository.impl;

import by.epam.jwdshape.entity.Cone;
import by.epam.jwdshape.repository.Specification;

public class CoordinateSpecification implements Specification {

	private double coordinateValue;
	private Axis coordinateAxis;

	public CoordinateSpecification(Axis coordinateAxis, double coordinateValue) {
		this.coordinateValue = coordinateValue;
		this.coordinateAxis = coordinateAxis;
	}

	public static enum Axis {
		X, Y, Z
	}

	@Override
	public boolean test(Cone cone) {
		return switch (coordinateAxis) {
		case X -> coordinateValue == cone.getCenter().getX();
		case Y -> coordinateValue == cone.getCenter().getY();
		case Z -> coordinateValue == cone.getCenter().getZ();
		};

	}

}

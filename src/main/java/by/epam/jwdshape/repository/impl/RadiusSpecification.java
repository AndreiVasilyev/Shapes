package by.epam.jwdshape.repository.impl;

import by.epam.jwdshape.entity.Cone;
import by.epam.jwdshape.repository.Specification;

public class RadiusSpecification implements Specification {

	private double radius;

	public RadiusSpecification(double radius) {
		this.radius = radius;
	}

	@Override
	public boolean test(Cone cone) {
		return radius == cone.getRadius();
	}

}

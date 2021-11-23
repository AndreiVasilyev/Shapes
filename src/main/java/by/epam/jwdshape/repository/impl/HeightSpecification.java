package by.epam.jwdshape.repository.impl;

import by.epam.jwdshape.entity.Cone;
import by.epam.jwdshape.repository.Specification;

public class HeightSpecification implements Specification {

	private double height;

	public HeightSpecification(double height) {
		this.height = height;
	}

	@Override
	public boolean test(Cone cone) {
		return height == cone.getHeight();
	}

}

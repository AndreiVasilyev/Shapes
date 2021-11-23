package by.epam.jwdshape.repository.impl;

import by.epam.jwdshape.entity.Cone;
import by.epam.jwdshape.repository.Specification;

public class InRangeFromOriginSpecification implements Specification {

	private double absX;
	private double absY;
	private double absZ;

	public InRangeFromOriginSpecification(double absX, double absY, double absZ) {
		this.absX = absX;
		this.absY = absY;
		this.absZ = absZ;
	}

	@Override
	public boolean test(Cone cone) {
		return absX > Math.abs(cone.getCenter().getX()) && absY > Math.abs(cone.getCenter().getY())
				&& absZ > Math.abs(cone.getCenter().getZ());
	}

}

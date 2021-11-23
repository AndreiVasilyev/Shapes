package by.epam.jwdshape.repository.impl;

import by.epam.jwdshape.entity.Cone;
import by.epam.jwdshape.exception.ConeException;
import by.epam.jwdshape.repository.Specification;
import by.epam.jwdshape.service.ConeService;
import by.epam.jwdshape.service.impl.ConeServiceImpl;

public class SurfaceAreaRangeSpecification implements Specification {

	private double minSurfaceArea;
	private double maxSurfaceArea;

	public SurfaceAreaRangeSpecification(double minSurfaceArea, double maxSurfaceArea) {
		this.minSurfaceArea = minSurfaceArea;
		this.maxSurfaceArea = maxSurfaceArea;
	}

	@Override
	public boolean test(Cone cone) {
		ConeService service = new ConeServiceImpl();
		double coneSurfaceArea;
		try {
			coneSurfaceArea = service.calculateSurfaceArea(cone);
		} catch (ConeException e) {
			return false;
		}
		return minSurfaceArea <= coneSurfaceArea && maxSurfaceArea >= coneSurfaceArea;
	}

}

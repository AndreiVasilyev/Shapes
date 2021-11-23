package by.epam.jwdshape.repository.impl;

import by.epam.jwdshape.entity.Cone;
import by.epam.jwdshape.exception.ConeException;
import by.epam.jwdshape.repository.Specification;
import by.epam.jwdshape.service.ConeService;
import by.epam.jwdshape.service.impl.ConeServiceImpl;

public class VolumeRangeSpecification implements Specification {

	private double minVolume;
	private double maxVolume;

	public VolumeRangeSpecification(double minVolume, double maxVolume) {
		this.minVolume = minVolume;
		this.maxVolume = maxVolume;
	}

	@Override
	public boolean test(Cone cone) {
		ConeService service = new ConeServiceImpl();
		double coneVolume;
		try {
			coneVolume = service.calculateSurfaceArea(cone);
		} catch (ConeException e) {
			return false;
		}
		return minVolume <= coneVolume && maxVolume >= coneVolume;
	}

}

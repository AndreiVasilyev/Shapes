package by.epam.jwdshape.observer.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.jwdshape.entity.Cone;
import by.epam.jwdshape.entity.ConeParameters;
import by.epam.jwdshape.entity.ConeWarehouse;
import by.epam.jwdshape.exception.ConeException;
import by.epam.jwdshape.observer.ConeEvent;
import by.epam.jwdshape.observer.ConeObserver;
import by.epam.jwdshape.service.ConeService;
import by.epam.jwdshape.service.impl.ConeServiceImpl;

public class ConeObserverImpl implements ConeObserver {

	private static final Logger log = LogManager.getLogger();

	@Override
	public void parametersChanged(ConeEvent event) {
		Cone cone = event.getSource();
		long id = cone.getId();
		ConeWarehouse coneWarehouse = ConeWarehouse.getInstance();
		ConeService coneService = new ConeServiceImpl();
		double surfaceArea;
		double newVolume;
		try {
			surfaceArea = coneService.calculateSurfaceArea(cone);
			newVolume = coneService.calculateVolume(cone);
			ConeParameters coneParametrs = new ConeParameters(surfaceArea, newVolume);
			coneWarehouse.put(id, coneParametrs);
			log.info("New parametrs of cone " + cone + " updated successfully");

		} catch (ConeException e) {
			log.error("Error when calculating new parameters to update warehouse: " + cone);
		}
	}

}

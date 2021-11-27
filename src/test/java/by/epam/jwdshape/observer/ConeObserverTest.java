package by.epam.jwdshape.observer;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import by.epam.jwdshape.entity.Cone;
import by.epam.jwdshape.entity.ConeParameters;
import by.epam.jwdshape.entity.ConeWarehouse;
import by.epam.jwdshape.entity.Point;
import by.epam.jwdshape.exception.ConeException;
import by.epam.jwdshape.observer.impl.ConeObserverImpl;
import by.epam.jwdshape.service.ConeService;
import by.epam.jwdshape.service.impl.ConeServiceImpl;

public class ConeObserverTest {

	@Test
	public void testObserverWithCorrectEvent() throws ConeException {
		ConeWarehouse warehouse = ConeWarehouse.getInstance();
		ConeService service = new ConeServiceImpl();
		Cone cone = new Cone(new Point(0, 0, 0), 10, 10);
		cone.attach(new ConeObserverImpl());
		double sufaceArea = service.calculateSurfaceArea(cone);
		double volume = service.calculateVolume(cone);
		warehouse.put(cone.getId(), new ConeParameters(sufaceArea, volume));
		cone.setHeight(20);
		double actualVolume = warehouse.get(cone.getId()).get().getVolume();
		assertEquals(actualVolume, 2094.4, 0.1);
	}

}

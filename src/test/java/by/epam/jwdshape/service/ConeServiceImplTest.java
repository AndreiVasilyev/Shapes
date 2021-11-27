package by.epam.jwdshape.service;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.epam.jwdshape.entity.Cone;
import by.epam.jwdshape.entity.Point;
import by.epam.jwdshape.exception.ConeException;
import by.epam.jwdshape.service.impl.ConeServiceImpl;

public class ConeServiceImplTest {

	private ConeService coneService;

	@BeforeClass
	public void setupParser() {
		coneService = new ConeServiceImpl();
	}

	@Test(expectedExceptions = ConeException.class)
	public void testCalculateSurfaceAreaWithWrongData() throws ConeException {
		Point point = new Point(0, 0, 0);
		Cone cone = new Cone(point, 0, 0);
		coneService.calculateSurfaceArea(cone);
	}

	@Test
	public void testCalculateSurfaceArea() throws ConeException {
		Point point = new Point(0, 0, 0);
		Cone cone = new Cone(point, 10.0, 20.0);
		double actualSurfaceArea = coneService.calculateSurfaceArea(cone);
		double expectedSurfaceArea = 1016.64;
		assertEquals(actualSurfaceArea, expectedSurfaceArea, 0.1);
	}

	@Test(expectedExceptions = ConeException.class)
	public void testCalculateVolumeWithWrongData() throws ConeException {
		Point point = new Point(0, 0, 0);
		Cone cone = new Cone(point, 0, 0);
		coneService.calculateSurfaceArea(cone);
	}

	@Test
	public void testCalculateVolume() throws ConeException {
		Point point = new Point(0, 0, 0);
		Cone cone = new Cone(point, 10.0, 20.0);
		double actualVolume = coneService.calculateVolume(cone);
		double expectedVolume = 2094.4;
		assertEquals(actualVolume, expectedVolume, 0.1);
	}

	@Test(expectedExceptions = ConeException.class)
	public void testCalculateCutConeVolumeRatioWithWrongConeData() throws ConeException {
		Point point = new Point(0, 0, 0);
		Cone cone = new Cone(point, 0, 0);
		coneService.calculateSurfaceArea(cone);
	}

	@Test(expectedExceptions = ConeException.class, expectedExceptionsMessageRegExp = "Wrong cut cone height when calculate cut cone volume ratio")
	public void testCalculateCutConeVolumeRatioWithWrongCutConeHeight() throws ConeException {
		Point point = new Point(0, 0, 0);
		Cone cone = new Cone(point, 10.0, 20.0);
		double cutConeHeight = 25.0;
		coneService.CalculateCutConeVolumeRatio(cone, cutConeHeight);
	}

	@Test
	public void testCalculateCutConeVolumeRatio() throws ConeException {
		Point point = new Point(0, 0, 0);
		Cone cone = new Cone(point, 10.0, 20.0);
		double cutConeHeight = 10.0;
		double actualRatio = coneService.CalculateCutConeVolumeRatio(cone, cutConeHeight);
		double expectedRatio = 8;
		assertEquals(actualRatio, expectedRatio, 0.1);
	}

	@Test(expectedExceptions = ConeException.class)
	public void testIsBaseConeOnCoordinatePlaneWithWrongData() throws ConeException {
		Point point = new Point(0, 0, 0);
		Cone cone = new Cone(point, 0, 0);
		coneService.isBaseConeOnCoordinatePlane(cone);
	}

	@Test
	public void testIsBaseConeOnCoordinatePlane() throws ConeException {
		Point point = new Point(0, 0, 0);
		Cone cone = new Cone(point, 10.0, 20.0);
		assertTrue(coneService.isBaseConeOnCoordinatePlane(cone));
	}

	@Test
	public void testIsBaseConeNotOnCoordinatePlane() throws ConeException {
		Point point = new Point(10, 10, 10);
		Cone cone = new Cone(point, 10.0, 20.0);
		assertFalse(coneService.isBaseConeOnCoordinatePlane(cone));
	}

	@Test
	public void testIsCone() throws ConeException {
		Point point = new Point(0, 0, 0);
		assertTrue(coneService.isCone(point, 20, 20));
	}

	@Test
	public void testIsNotCone() throws ConeException {
		Point point = new Point(0, 0, 0);
		assertFalse(coneService.isCone(point, 10, -20));
	}
}

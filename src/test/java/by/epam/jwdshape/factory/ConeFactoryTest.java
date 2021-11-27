package by.epam.jwdshape.factory;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import by.epam.jwdshape.entity.Cone;
import by.epam.jwdshape.entity.Point;
import by.epam.jwdshape.exception.ConeException;

public class ConeFactoryTest {

	@Test
	public void testCorrectCreateConeByDoubleArray() throws ConeException {
		double[] params = { 0, 0, 0, 10, 10 };
		Cone cone = ConeFactory.create(params);
		assertNotNull(cone);
	}

	@Test(expectedExceptions = ConeException.class)
	public void testIncorrectCreateConeByDoubleArray() throws ConeException {
		double[] params = { 0, 0, 0, -10 };
		ConeFactory.create(params);
	}

	@Test
	public void testCorrectCreateConeByParameters() throws ConeException {
		Cone cone = ConeFactory.create(0, 0, 0, 10, 10);
		assertNotNull(cone);
	}

	@Test(expectedExceptions = ConeException.class)
	public void testIncorrectCreateConeByParameters() throws ConeException {
		ConeFactory.create(0, 0, 0, -10, -10);
	}

	@Test
	public void testCorrectCreateConeByPointAndParameters() throws ConeException {
		Point point = new Point(-10, 0, 20);
		Cone cone = ConeFactory.create(point, 10, 10);
		assertNotNull(cone);
	}

	@Test(expectedExceptions = ConeException.class)
	public void testIncorrectCreateConeByPointParameters() throws ConeException {
		Point point = new Point(-1002, 0, 20);
		ConeFactory.create(point, -10, -10);
	}

}

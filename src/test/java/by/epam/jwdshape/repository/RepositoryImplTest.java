package by.epam.jwdshape.repository;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.epam.jwdshape.comparator.ConeHeightComparator;
import by.epam.jwdshape.comparator.ConeIdComparator;
import by.epam.jwdshape.comparator.ConeRadiusComparator;
import by.epam.jwdshape.comparator.ConeXCoordinateComparator;
import by.epam.jwdshape.comparator.ConeYCoordinateComparator;
import by.epam.jwdshape.comparator.ConeZCoordinateComparator;
import by.epam.jwdshape.entity.Cone;
import by.epam.jwdshape.entity.Point;
import by.epam.jwdshape.exception.ConeException;
import by.epam.jwdshape.factory.ConeFactory;
import by.epam.jwdshape.main.Main;
import by.epam.jwdshape.parser.ShapeParser;
import by.epam.jwdshape.parser.impl.ConeParser;
import by.epam.jwdshape.reader.ShapeReader;
import by.epam.jwdshape.reader.impl.ConeFileReader;
import by.epam.jwdshape.repository.impl.CoordinateSpecification;
import by.epam.jwdshape.repository.impl.HeightSpecification;
import by.epam.jwdshape.repository.impl.IdSpecification;
import by.epam.jwdshape.repository.impl.RadiusSpecification;
import by.epam.jwdshape.repository.impl.RepositoryImpl;
import by.epam.jwdshape.repository.impl.SurfaceAreaRangeSpecification;
import by.epam.jwdshape.repository.impl.VolumeRangeSpecification;
import by.epam.jwdshape.util.ConeIdGenerator;

public class RepositoryImplTest {

	private Repository repository;
	private List<Cone> copyOfRepositoryList;
	private Cone testCone;

	@BeforeClass
	public void prpareRepository() throws ConeException {
		String path = Main.class.getResource("/data/cones.txt").getPath();
		path = path.substring(1);

		testCone = new Cone(new Point(0, 0, 0), 2, 2);
		repository = RepositoryImpl.getInstance();
		ShapeReader reader = new ConeFileReader();
		ShapeParser parser = new ConeParser();
		ConeIdGenerator.reset();
		List<String> cones = reader.readLines(path);
		List<double[]> params = parser.parse(cones).orElse(new ArrayList<>());
		copyOfRepositoryList = new ArrayList<>();

		for (double[] param : params) {
			Cone cone = ConeFactory.create(param);
			repository.add(cone);
			copyOfRepositoryList.add(cone);
		}		
	}

	@AfterMethod
	public void resetRepository() {
		repository.clear();
		repository.addAll(copyOfRepositoryList);
	}

	@Test
	public void testGetConeList() {
		assertNotNull(repository.get());
	}

	@Test
	public void testAddCorrectCone() throws ConeException {
		assertTrue(repository.add(testCone));
	}

	@Test(expectedExceptions = ConeException.class)
	public void testAddIncorrectCone() throws ConeException {
		repository.add(new Cone(new Point(0, 0, 0), -2, 2));
	}

	@Test
	public void testAddAllCorrectCones() throws ConeException {
		assertTrue(repository.addAll(copyOfRepositoryList));
	}

	@Test
	public void testAddAllIncorrectCones() throws ConeException {
		assertFalse(repository.addAll(Collections.emptyList()));
	}

	@Test
	public void testRemoveCorrectCone() throws ConeException {
		repository.add(testCone);
		assertTrue(repository.remove(testCone));
	}

	@Test
	public void testRemoveIncorrectCone() throws ConeException {
		assertFalse(repository.remove(new Cone(new Point(0, 0, 0), 100, 2)));
	}

	@Test
	public void testClearRepository() throws ConeException {
		repository.clear();
		assertTrue(repository.get().isEmpty());
	}

	@Test
	public void testGetCone() throws ConeException {
		repository.add(testCone);
		int index = repository.get().indexOf(testCone);
		assertEquals(repository.get(index), testCone);
	}

	@Test
	public void testSetCone() throws ConeException {
		repository.set(5, testCone);
		assertEquals(repository.get(5), testCone);
	}

	@Test
	public void testQueryByIdSpecification() throws ConeException {
		List<Cone> actualQueryResult = repository.query(new IdSpecification(2));
		assertEquals(actualQueryResult.size(), 1);
	}

	@Test
	public void testQueryByRadiusSpecification() throws ConeException {
		List<Cone> actualQueryResult = repository.query(new RadiusSpecification(3));
		assertEquals(actualQueryResult.size(), 1);
	}

	@Test
	public void testQueryByHieghtSpecification() throws ConeException {
		List<Cone> actualQueryResult = repository.query(new HeightSpecification(3));
		assertEquals(actualQueryResult.size(), 1);
	}

	@Test
	public void testQueryByCoordinateSpecification() throws ConeException {
		List<Cone> actualQueryResult = repository.query(new CoordinateSpecification(CoordinateSpecification.Axis.X, 0));
		assertEquals(actualQueryResult.size(), 1);
	}

	@Test
	public void testQueryBySurfaceAreaRangeSpecification() throws ConeException {
		List<Cone> actualQueryResult = repository.query(new SurfaceAreaRangeSpecification(0, 100));
		assertEquals(actualQueryResult.size(), 1);
	}

	@Test
	public void testQueryByVolumeSpecification() throws ConeException {
		List<Cone> actualQueryResult = repository.query(new VolumeRangeSpecification(0, 100));
		assertEquals(actualQueryResult.size(), 1);
	}

	@Test
	public void testSortById() throws ConeException {
		List<Cone> actualSortedList = repository.sort(new ConeIdComparator());
		assertEquals(actualSortedList, copyOfRepositoryList);
	}

	@Test
	public void testSortByXCoordinate() throws ConeException {
		List<Cone> actualSortedList = repository.sort(new ConeXCoordinateComparator());
		assertEquals(actualSortedList.get(0).getId(), 5);
	}

	@Test
	public void testSortByYCoordinate() throws ConeException {
		List<Cone> actualSortedList = repository.sort(new ConeYCoordinateComparator());
		assertEquals(actualSortedList.get(0).getId(), 6);
	}

	@Test
	public void testSortByZCoordinate() throws ConeException {
		List<Cone> actualSortedList = repository.sort(new ConeZCoordinateComparator());
		assertEquals(actualSortedList.get(0).getId(), 5);
	}

	@Test
	public void testSortByRadiusCoordinate() throws ConeException {
		List<Cone> actualSortedList = repository.sort(new ConeRadiusComparator());
		assertEquals(actualSortedList.get(0).getId(), 6);
	}

	@Test
	public void testSortByHeigtCoordinate() throws ConeException {
		List<Cone> actualSortedList = repository.sort(new ConeHeightComparator());
		assertEquals(actualSortedList.get(0).getId(), 6);
	}
}

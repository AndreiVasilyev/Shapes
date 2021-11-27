package by.epam.jwdshape.parser;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import by.epam.jwdshape.parser.impl.ConeParser;

public class ConeParserTest {

	private ShapeParser parser;

	@BeforeClass
	public void setupParser() {
		parser = new ConeParser();
	}

	@Test
	public void testNullSourceLine() {
		assertTrue(parser.parse((String) null).isEmpty());
	}

	@Test
	public void testBlankSourceLine() {
		assertTrue(parser.parse("").isEmpty());
	}

	@Test(dataProvider = "correctLines")
	public void testCorrectLine(String sourceLine, List<Double> expectedList) {
		double[] actualArray = parser.parse(sourceLine).get();
		Object[] expectedArray = expectedList.toArray();
		assertEquals(actualArray, expectedArray);
	}

	@DataProvider(name = "correctLines")
	public Object[][] dataForTestCorrectLines() {
		return new Object[][] { { "  -45 52     -8 5.5 87 ", List.of(-45d, 52d, -8d, 5.5, 87d) },
				{ "1 2 3 5 6", List.of(1d, 2d, 3d, 5d, 6d) },
				{ "1.5 2.4 1.4 5.5 6.6", List.of(1.5, 2.4, 1.4, 5.5, 6.6) },
				{ "8 5 9 8.4 11", List.of(8d, 5d, 9d, 8.4, 11d) }, { "0 0 0 3 3", List.of(0d, 0d, 0d, 3d, 3d) } };
	}

	@Test(dataProvider = "incorrectLines")
	public void testIncorrectLine(String sourceLine) {
		Optional<double[]> actualArray = parser.parse(sourceLine);
		assertTrue(actualArray.isEmpty());
	}

	@DataProvider(name = "incorrectLines")
	public Object[][] dataForTestIncorrectLines() {
		return new Object[][] { { "a b c d e" }, { "8888" }, { "!1 5 8 4.5 2" }, { "8.5 7.4 6.2 5.8 9 9" },
				{ "54 -87 -98 -1 2" }, { "0 0 0 0 0" } };
	}

	@Test(dataProvider = "listLines")
	public void testListLines(List<String> sourceList, List<List<Double>> expectedData) {
		List<double[]> actualListData = parser.parse(sourceList).get();
		List<double[]> expectedList = expectedData.stream()
				.map(list -> list.stream().mapToDouble(value -> value).toArray()).toList();
		for (double[] actualArray : actualListData) {
			assertEquals(actualArray, expectedList.get(actualListData.indexOf(actualArray)));
		}
	}

	@DataProvider(name = "listLines")
	public Object[][] dataForTestListLines() {
		return new Object[][] { {
				List.of("  -45 52     -8 5.5 87 ", "1 2 3 5 6", "1.5 2.4 1.4 5.5 6.6", "8 5 9 8.4 11", "0 0 0 3 3",
						"a b c d e", "8888", "!1 5 8 4.5 2", "8.5 7.4 6.2 5.8 9 9", "54 -87 -98 -1 2", "0 0 0 0 0"),
				List.of(List.of(-45d, 52d, -8d, 5.5, 87d), List.of(1d, 2d, 3d, 5d, 6d),
						List.of(1.5, 2.4, 1.4, 5.5, 6.6), List.of(8d, 5d, 9d, 8.4, 11d),
						List.of(0d, 0d, 0d, 3d, 3d)) } };
	}

	@Test
	public void testNullSourceList() {
		assertTrue(parser.parse((List<String>) null).isEmpty());
	}

	@Test
	public void testEmptySourceList() {
		List<double[]> actualList = parser.parse(Collections.emptyList()).get();
		List<double[]> expectedArray = List.of();
		assertEquals(actualList, expectedArray);
	}

}

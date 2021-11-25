package by.epam.jwdshape.parser;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.testng.annotations.BeforeClass;
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

	@Test
	public void testCorrectLine() {		
		double[] actualArray = parser.parse("  -45 52     -8 5.5 87 ").get();
		double[] expectedArray = { -45d, 52d, -8d, 5.5d, 87d };
		assertEquals(actualArray, expectedArray);
	}
	
	@Test
	public void testIncorrectLine() {		
		Optional<double[]> actualArray = parser.parse("a a");		
		assertTrue(actualArray.isEmpty());
	}

	@Test
	public void testNullSourceList() {
		assertTrue(parser.parse((List<String>) null).isEmpty());
	}

	@Test
	public void testEmptySourceList() {
		assertTrue(parser.parse(Collections.emptyList()).isEmpty());
	}

}

package by.epam.jwdshape.util;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class ConeIdGeneratorTest {

	@Test
	public void testFirstValueIdGenerator() {
		assertEquals(ConeIdGenerator.generateId(), 1);
	}

	@Test
	public void testSequenceOfNumbersIdGenerator() {
		ConeIdGenerator.reset();
		long[] actualArray = new long[10];
		for (int i = 0; i < actualArray.length; i++) {
			actualArray[i] = ConeIdGenerator.generateId();
		}
		long[] expectedArray = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		assertEquals(actualArray, expectedArray);
	}
}

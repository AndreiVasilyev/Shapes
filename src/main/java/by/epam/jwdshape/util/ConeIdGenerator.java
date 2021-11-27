package by.epam.jwdshape.util;

public class ConeIdGenerator {

	private static long counter;

	private ConeIdGenerator() {
	}

	public static long generateId() {
		return ++counter;
	}

	public static void reset() {
		counter = 0;
	}

}

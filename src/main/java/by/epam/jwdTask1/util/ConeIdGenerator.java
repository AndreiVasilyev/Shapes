package by.epam.jwdTask1.util;

public class ConeIdGenerator {

	private static long counter;

	private ConeIdGenerator() {
	}

	public static long generateId() {
		return ++counter;
	}

}

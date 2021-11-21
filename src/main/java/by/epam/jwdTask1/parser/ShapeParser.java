package by.epam.jwdTask1.parser;

import by.epam.jwdTask1.exception.ConeException;

public interface ShapeParser {

	public double[] parse(String line) throws ConeException;
}

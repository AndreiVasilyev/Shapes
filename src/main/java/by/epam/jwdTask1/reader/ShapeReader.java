package by.epam.jwdTask1.reader;

import java.util.List;

import by.epam.jwdTask1.exception.ConeException;

public interface ShapeReader {

	public List<String> readLines(String path) throws ConeException;
}

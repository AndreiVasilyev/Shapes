package by.epam.jwdshape.reader;

import java.util.List;

import by.epam.jwdshape.exception.ConeException;

public interface ShapeReader {

	List<String> readLines(String path) throws ConeException;
}

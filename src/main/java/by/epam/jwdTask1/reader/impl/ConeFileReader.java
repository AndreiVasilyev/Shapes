package by.epam.jwdTask1.reader.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.jwdTask1.exception.ConeException;
import by.epam.jwdTask1.reader.ShapeReader;
import by.epam.jwdTask1.validator.ConeStringValidator;

public class ConeFileReader implements ShapeReader {

	private final static Logger log = LogManager.getLogger();

	public List<String> readLines(String path) throws ConeException {

		if (path == null || path.isBlank()) {
			throw new ConeException("There is no file path to read data");
		}

		Path filePath = Paths.get(path);
		List<String> result;

		try {
			result = Files.lines(filePath, StandardCharsets.UTF_8).filter(ConeStringValidator::isConeStringValid)
					.collect(Collectors.toList());
		} catch (IOException e) {
			log.error("Error when reading file with source data from " + path);
			throw new ConeException("Error when reading file with source data " + path, e);
		}
		log.info("File read successfully");
		return result;
	}

}

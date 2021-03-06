package by.epam.jwdshape.reader.impl;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.jwdshape.exception.ConeException;
import by.epam.jwdshape.reader.ShapeReader;
import by.epam.jwdshape.validator.ConeStringValidator;
import by.epam.jwdshape.validator.impl.ConeStringValidatorImpl;

public class ConeFileReader implements ShapeReader {

	private static final Logger log = LogManager.getLogger();

	public List<String> readLines(String path) throws ConeException {

		if (path == null || path.isBlank()) {
			log.error("There is no file path to read data");
			throw new ConeException("There is no file path to read data");
		}

		Path filePath = Paths.get(path);
		List<String> result;
		ConeStringValidator coneStringValidator = new ConeStringValidatorImpl();
		try {
			result = Files.lines(filePath, StandardCharsets.UTF_8).filter(coneStringValidator::isConeStringValid)
					.toList();
		} catch (IOException e) {
			log.error("Error when reading file with source data from " + path);
			throw new ConeException("Error when reading file with source data " + path, e);
		}
		log.info("File read successfully");
		return result;
	}

}

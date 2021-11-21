package by.epam.jwdTask1.parser.impl;

import java.util.stream.Stream;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epam.jwdTask1.exception.ConeException;
import by.epam.jwdTask1.parser.ShapeParser;
import by.epam.jwdTask1.validator.ConeParametersValidator;

public class ConeParser implements ShapeParser {

	private final static String DELIMITER_REGEX = "\\s+";
	private final static Logger log = LogManager.getLogger();

	@Override
	public double[] parse(String line) throws ConeException {

		if (line == null || line.isBlank()) {
			log.error("There is no string for parsing");
			throw new ConeException("There is no string for parsing");
		}

		String[] splitedLine = line.trim().split(DELIMITER_REGEX);
		double[] result = null;
		try {
			result = Stream.of(splitedLine).mapToDouble(Double::parseDouble).toArray();
			log.info("Line parsed successfully");
		} catch (Exception e) {
			log.error("There is error when parsing string to double");
		}
		return ConeParametersValidator.isConeParamValid(result) ? result : null;
	}

}

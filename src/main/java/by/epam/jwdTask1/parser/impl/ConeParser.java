package by.epam.jwdTask1.parser.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import by.epam.jwdTask1.parser.ShapeParser;
import by.epam.jwdTask1.validator.ConeParametersValidator;
import by.epam.jwdTask1.validator.ConeStringValidator;

public class ConeParser implements ShapeParser {

	private final static String DELIMITER_REGEX = "\\s+";

	@Override
	public Optional<double[]> parse(String line) {

		return Optional.ofNullable(line).filter(ConeStringValidator::isConeStringValid)
				.map(l -> l.trim().split(DELIMITER_REGEX))
				.map(splitedString -> Stream.of(splitedString).mapToDouble(Double::parseDouble).toArray())
				.filter(ConeParametersValidator::isConeParamValid);

		// TODO
		/*
		 * String[] splitedLine = line.trim().split(DELIMITER_REGEX); double[] result =
		 * null; try { result =
		 * Stream.of(splitedLine).mapToDouble(Double::parseDouble).toArray();
		 * log.info("Line parsed successfully"); } catch (Exception e) {
		 * log.error("There is error when parsing string to double"); } return
		 * ConeParametersValidator.isConeParamValid(result) ? result : null;
		 */
	}

	@Override
	public Optional<List<double[]>> parse(List<String> lines) {

		return Optional.ofNullable(lines.stream().filter(ConeStringValidator::isConeStringValid)
				.map(line -> line.trim().split(DELIMITER_REGEX))
				.map(splitedString -> Stream.of(splitedString).mapToDouble(Double::parseDouble).toArray())
				.filter(ConeParametersValidator::isConeParamValid)
				.collect(Collectors.toList()));

	}

}

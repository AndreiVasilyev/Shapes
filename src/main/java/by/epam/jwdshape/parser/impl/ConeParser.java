package by.epam.jwdshape.parser.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import by.epam.jwdshape.parser.ShapeParser;
import by.epam.jwdshape.validator.ConeParametersValidator;
import by.epam.jwdshape.validator.ConeStringValidator;
import by.epam.jwdshape.validator.impl.ConeParametersValidatorImpl;
import by.epam.jwdshape.validator.impl.ConeStringValidatorImpl;

public class ConeParser implements ShapeParser {

	private static final String DELIMITER_REGEX = "\\s+";

	@Override
	public Optional<double[]> parse(String line) {

		ConeStringValidator coneStringValidator = new ConeStringValidatorImpl();
		ConeParametersValidator coneParametersValidator = new ConeParametersValidatorImpl();
		return Optional.ofNullable(line).filter(coneStringValidator::isConeStringValid)
				.map(l -> l.trim().split(DELIMITER_REGEX))
				.map(splitedString -> Stream.of(splitedString).mapToDouble(Double::parseDouble).toArray())
				.filter(coneParametersValidator::isConeParamValid);
	}

	@Override
	public Optional<List<double[]>> parse(List<String> lines) {

		ConeStringValidator coneStringValidator = new ConeStringValidatorImpl();
		ConeParametersValidator coneParametersValidator = new ConeParametersValidatorImpl();
		return Optional.ofNullable(lines.stream().filter(coneStringValidator::isConeStringValid)
				.map(line -> line.trim().split(DELIMITER_REGEX))
				.map(splitedString -> Stream.of(splitedString).mapToDouble(Double::parseDouble).toArray())
				.filter(coneParametersValidator::isConeParamValid).collect(Collectors.toList()));

	}

}

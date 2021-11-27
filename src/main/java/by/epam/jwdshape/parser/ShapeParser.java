package by.epam.jwdshape.parser;

import java.util.List;
import java.util.Optional;

public interface ShapeParser {

	Optional<double[]> parse(String line);

	Optional<List<double[]>> parse(List<String> lines);
}

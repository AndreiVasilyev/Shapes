package by.epam.jwdTask1.parser;

import java.util.List;
import java.util.Optional;

public interface ShapeParser {

	public Optional<double[]> parse(String line);

	public Optional<List<double[]>> parse(List<String> lines);
}

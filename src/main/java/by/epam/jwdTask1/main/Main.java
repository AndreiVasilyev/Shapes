package by.epam.jwdTask1.main;

import java.util.ArrayList;
import java.util.List;

import by.epam.jwdTask1.exception.ConeException;
import by.epam.jwdTask1.factory.ConeFactory;
import by.epam.jwdTask1.parser.ShapeParser;
import by.epam.jwdTask1.parser.impl.ConeParser;
import by.epam.jwdTask1.reader.ShapeReader;
import by.epam.jwdTask1.reader.impl.ConeFileReader;

public class Main {

	public static void main(String[] args) throws ConeException {
		String path = Main.class.getResource("/data/cones.txt").getPath();
		path = path.substring(1);

		ShapeReader reader = new ConeFileReader();
		ShapeParser parser = new ConeParser();
		List<String> cones = reader.readLines(path);
		for (String cone : cones) {
			System.out.println(cone);
		}

		List<double[]> params = new ArrayList<>();
		for (String string : cones) {
			params.add(parser.parse(string));
		}
		for (double[] param : params) {

			if (param != null)
				System.out.println(ConeFactory.create(param));
		}

		// List<Cone>
		// cones2=params.stream().map(ConeFactory::create).collect(Collectors.toList());

		// cones.stream().map(line->parser.parse(line);)
	}

}

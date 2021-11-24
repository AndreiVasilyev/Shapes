package by.epam.jwdshape.main;

import java.util.List;

import by.epam.jwdshape.entity.Cone;
import by.epam.jwdshape.entity.Point;
import by.epam.jwdshape.exception.ConeException;
import by.epam.jwdshape.factory.ConeFactory;
import by.epam.jwdshape.parser.ShapeParser;
import by.epam.jwdshape.parser.impl.ConeParser;
import by.epam.jwdshape.reader.ShapeReader;
import by.epam.jwdshape.reader.impl.ConeFileReader;
import by.epam.jwdshape.repository.Repository;
import by.epam.jwdshape.repository.impl.CoordinateSpecification;
import by.epam.jwdshape.repository.impl.RepositoryImpl;

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

		List<double[]> params = parser.parse(cones).get();

		for (double[] param : params) {
			if (param != null)
				System.out.println(ConeFactory.create(param));
		}
		
		Repository rep = RepositoryImpl.getInstance();
		rep.add(new Cone(new Point(2, 3, 4), 5, 8));
		
		
		System.out.println(rep.query(new CoordinateSpecification(CoordinateSpecification.Axis.X, 2)));
	}

}

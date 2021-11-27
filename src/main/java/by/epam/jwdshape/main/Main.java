package by.epam.jwdshape.main;

import java.util.ArrayList;
import java.util.List;

import by.epam.jwdshape.entity.Cone;
import by.epam.jwdshape.entity.ConeParameters;
import by.epam.jwdshape.entity.ConeWarehouse;
import by.epam.jwdshape.exception.ConeException;
import by.epam.jwdshape.factory.ConeFactory;
import by.epam.jwdshape.observer.ConeObserver;
import by.epam.jwdshape.observer.impl.ConeObserverImpl;
import by.epam.jwdshape.parser.ShapeParser;
import by.epam.jwdshape.parser.impl.ConeParser;
import by.epam.jwdshape.reader.ShapeReader;
import by.epam.jwdshape.reader.impl.ConeFileReader;
import by.epam.jwdshape.repository.Repository;
import by.epam.jwdshape.repository.impl.RepositoryImpl;
import by.epam.jwdshape.service.ConeService;
import by.epam.jwdshape.service.impl.ConeServiceImpl;

public class Main {

	public static void main(String[] args) throws ConeException {
		String path = Main.class.getResource("/data/cones.txt").getPath();
		path = path.substring(1);

		ShapeReader reader = new ConeFileReader();
		ShapeParser parser = new ConeParser();
		Repository repository = RepositoryImpl.getInstance();
		ConeWarehouse wareHouse=ConeWarehouse.getInstance();
		ConeService service=new ConeServiceImpl();
		
		
		List<String> cones = reader.readLines(path);
		for (String cone : cones) {
			System.out.println(cone);
		}

		List<double[]> params = parser.parse(cones).orElse(new ArrayList<>());		
		for (double[] param : params) {	
			Cone cone=ConeFactory.create(param);
			ConeObserver observer=new ConeObserverImpl();
			cone.attach(observer);
			repository.add(cone);
			ConeParameters parameters=new ConeParameters(service.calculateSurfaceArea(cone), service.calculateVolume(cone));
			wareHouse.put(cone.getId(), parameters);
		}
		
		System.out.println(repository.get(0));
		repository.get(0).setHeight(50);
		System.out.println(repository.get(0));
	}

}

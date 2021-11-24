package by.epam.jwdshape.comparator;

import java.util.Comparator;

import by.epam.jwdshape.entity.Cone;

public class ConeXCoordinateComparator implements Comparator<Cone> {

	@Override
	public int compare(Cone o1, Cone o2) {
		return Double.compare(o1.getCenter().getX(), o2.getCenter().getX());
	}

}

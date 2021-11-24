package by.epam.jwdshape.comparator;

import java.util.Comparator;

import by.epam.jwdshape.entity.Cone;

public class ConeIdComparator implements Comparator<Cone> {

	@Override
	public int compare(Cone o1, Cone o2) {
		return Long.compare(o1.getId(), o2.getId());
	}
}

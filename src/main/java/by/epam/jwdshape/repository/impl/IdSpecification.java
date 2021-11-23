package by.epam.jwdshape.repository.impl;

import by.epam.jwdshape.entity.Cone;
import by.epam.jwdshape.repository.Specification;

public class IdSpecification implements Specification {

	private long id;

	public IdSpecification(long id) {
		this.id = id;
	}

	@Override
	public boolean test(Cone cone) {
		return id == cone.getId();
	}

}

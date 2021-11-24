package by.epam.jwdshape.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ConeWarehouse {

	private static ConeWarehouse instance;
	private Map<Long, ConeParameters> parameters;

	private ConeWarehouse() {
		parameters = new HashMap<Long, ConeParameters>();
	}

	public static ConeWarehouse getInstance() {
		if (instance == null) {
			instance = new ConeWarehouse();
		}
		return instance;
	}

	public Optional<ConeParameters> get(long id) {
		return Optional.ofNullable(parameters.get(id));
	}

	public Optional<ConeParameters> put(long id, ConeParameters parameter) {
		return Optional.ofNullable(parameters.put(id, parameter));
	}

	public Optional<ConeParameters> remove(long id) {
		return Optional.ofNullable(parameters.remove(id));
	}

}

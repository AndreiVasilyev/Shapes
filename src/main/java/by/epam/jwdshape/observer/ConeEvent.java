package by.epam.jwdshape.observer;

import java.util.EventObject;

import by.epam.jwdshape.entity.Cone;

public class ConeEvent extends EventObject {

	private static final long serialVersionUID = 1L;

	public ConeEvent(Cone source) {
		super(source);
	}

	@Override
	public Cone getSource() {
		return (Cone) super.getSource();
	}
}

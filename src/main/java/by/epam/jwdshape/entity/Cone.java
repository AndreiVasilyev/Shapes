package by.epam.jwdshape.entity;

import by.epam.jwdshape.exception.ConeException;
import by.epam.jwdshape.observer.ConeEvent;
import by.epam.jwdshape.observer.ConeObservable;
import by.epam.jwdshape.observer.ConeObserver;
import by.epam.jwdshape.util.ConeIdGenerator;
import by.epam.jwdshape.validator.ConeParametersValidator;
import by.epam.jwdshape.validator.impl.ConeParametersValidatorImpl;

public class Cone implements ConeObservable {

	private final long id;
	private Point center;
	private double radius;
	private double height;
	private ConeObserver observer;

	public Cone(Point center, double radius, double height) throws ConeException {
		ConeParametersValidator validator = new ConeParametersValidatorImpl();
		if (!validator.isConeParamValid(center.getX(), center.getY(), center.getZ(), radius, height)) {
			throw new ConeException();
		}
		this.id = ConeIdGenerator.generateId();
		this.center = center;
		this.radius = radius;
		this.height = height;
	}

	public long getId() {
		return id;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
		notifyObservers();
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
		notifyObservers();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((center == null) ? 0 : center.hashCode());
		long temp;
		temp = Double.doubleToLongBits(height);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(radius);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cone other = (Cone) obj;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		if (Double.doubleToLongBits(height) != Double.doubleToLongBits(other.height))
			return false;
		if (Double.doubleToLongBits(radius) != Double.doubleToLongBits(other.radius))
			return false;
		return true;
	}

	@Override
	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Cone [id=");
		stringBuilder.append(id);
		stringBuilder.append(", center=(");
		stringBuilder.append(center.getX());
		stringBuilder.append(", ");
		stringBuilder.append(center.getY());
		stringBuilder.append(", ");
		stringBuilder.append(center.getZ());
		stringBuilder.append("), radius=");
		stringBuilder.append(radius);
		stringBuilder.append(", height=");
		stringBuilder.append(height);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	@Override
	public void attach(ConeObserver observer) {
		this.observer = observer;
	}

	@Override
	public void detach() {
		this.observer = null;
	}

	@Override
	public void notifyObservers() {
		if (observer == null) {
			return;
		}
		ConeEvent coneEvent = new ConeEvent(this);
		observer.parametersChanged(coneEvent);
	}

}

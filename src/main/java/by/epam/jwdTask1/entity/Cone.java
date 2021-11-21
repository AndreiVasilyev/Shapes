package by.epam.jwdTask1.entity;

import by.epam.jwdTask1.util.ConeIdGenerator;

public class Cone {

	private final long id;
	private Point center;
	private double radius;
	private double height;

	public Cone(Point center, double radius, double height) {
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
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
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

}

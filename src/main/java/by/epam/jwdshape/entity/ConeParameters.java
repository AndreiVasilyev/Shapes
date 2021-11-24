package by.epam.jwdshape.entity;

public class ConeParameters {

	private double surfaceArea;
	private double volume;

	public ConeParameters(double surfaceArea, double volume) {
		this.surfaceArea = surfaceArea;
		this.volume = volume;
	}

	public double getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(surfaceArea);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(volume);
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
		ConeParameters other = (ConeParameters) obj;
		if (Double.doubleToLongBits(surfaceArea) != Double.doubleToLongBits(other.surfaceArea))
			return false;
		if (Double.doubleToLongBits(volume) != Double.doubleToLongBits(other.volume))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("ConeParameters [surfaceArea=");
		stringBuilder.append(surfaceArea);
		stringBuilder.append(", volume=");
		stringBuilder.append(volume);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

}

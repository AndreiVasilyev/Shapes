package by.epam.jwdshape.validator;

public interface ConeParametersValidator {

	public boolean isConeParamValid(double x, double y, double z, double radius, double height);

	public boolean isConeParamValid(double[] params);
	
	public boolean isCutConeHeightValid(double cutConeHeight);
}

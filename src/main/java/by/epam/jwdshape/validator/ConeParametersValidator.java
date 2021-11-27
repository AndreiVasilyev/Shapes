package by.epam.jwdshape.validator;

public interface ConeParametersValidator {

	boolean isConeParamValid(double x, double y, double z, double radius, double height);

	boolean isConeParamValid(double[] params);

	boolean isCutConeHeightValid(double cutConeHeight, double coneHeight);
}

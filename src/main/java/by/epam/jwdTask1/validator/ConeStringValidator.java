package by.epam.jwdTask1.validator;

public class ConeStringValidator {

	private final static String CONE_STRING_REGEX = "^(-?\\d+(\\.\\d{1,2})?\\s){3}(\\d+(\\.\\d{1,2})?\\s)(\\d+(\\.\\d{1,2})?)$";

	public static boolean isConeStringValid(String line) {
		String trimedString = line.trim();
		boolean result = trimedString.matches(CONE_STRING_REGEX);
		return result;
	}
}

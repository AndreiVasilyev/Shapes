package by.epam.jwdTask1.exception;

public class ConeException extends Exception {

	private static final long serialVersionUID = 1L;

	public ConeException() {
		super();
	}

	public ConeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ConeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConeException(String message) {
		super(message);
	}

	public ConeException(Throwable cause) {
		super(cause);
	}

}

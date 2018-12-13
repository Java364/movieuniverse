package academy.softserve.movieuniverse.exception;

import javax.validation.ValidationException;

public class CustomValidationException extends ValidationException {

	private static final long serialVersionUID = 532670066458655797L;
	private String customMessage = "";
	private ExceptionType exceptionType;

	public CustomValidationException(String customMessage, ExceptionType exceptionType, Exception ex) {
		super(ex == null ? new Exception().getMessage() : ex.getMessage());
		this.customMessage = customMessage;
		this.exceptionType = exceptionType;
	}

	public String getCustomMessage() {
		return customMessage;
	}

	public ExceptionType getExceptionType() {
		return exceptionType;
	}

}

package academy.softserve.movieuniverse.exception;

public class CountryException extends CustomValidationException{

	private static final long serialVersionUID = -6283677404347365061L;

	private CountryException(String customMessage, ExceptionType exceptionType, Exception ex) {
		super(customMessage, exceptionType, ex);
	}
	
	public static CountryException createSaveException(String message, Exception ex) {
		return new CountryException(message, ExceptionType.SAVE, ex);
	}

}

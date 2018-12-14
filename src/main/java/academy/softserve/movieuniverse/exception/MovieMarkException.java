package academy.softserve.movieuniverse.exception;

public class MovieMarkException extends CustomValidationException{

	private static final long serialVersionUID = -9023090121189027086L;

	public MovieMarkException(String message, ExceptionType exceptionType, Exception ex) {
		super(message, exceptionType, ex);
	}

}

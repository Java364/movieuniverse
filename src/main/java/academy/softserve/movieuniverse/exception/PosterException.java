package academy.softserve.movieuniverse.exception;

public class PosterException extends CustomValidationException {
	private static final long serialVersionUID = 1L;

	public PosterException(String customMessage, ExceptionType exceptionType, Exception ex) {
		super(customMessage, exceptionType, ex);

	}

	public static PosterException createSaveException(String message, Exception ex) {
		return new PosterException(message, ExceptionType.SAVE, ex);
	}

	public static PosterException createDeleteException(String message, Exception ex) {
		return new PosterException(message, ExceptionType.DELETE, ex);
	}

	public static PosterException createSelectException(String message, Exception ex) {
		return new PosterException(message, ExceptionType.SELECT, ex);
	}
	public static PosterException createUpdateException(String message, Exception ex) {
		return new PosterException(message, ExceptionType.UPDATE, ex);
	}
}

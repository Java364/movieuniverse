package academy.softserve.movieuniverse.exception;

public class StarActivityInMoviesException extends CustomValidationException {

    private static final long serialVersionUID = -3985512392092434898L;

    private StarActivityInMoviesException(String customMessage, ExceptionType exceptionType, Exception ex) {
        super(customMessage, exceptionType, ex);
    }

    public static StarActivityInMoviesException createSaveException(String message, Exception ex) {
        return new StarActivityInMoviesException(message, ExceptionType.SAVE, ex);
    }

    public static StarActivityInMoviesException createDeleteException(String message, Exception ex) {
        return new StarActivityInMoviesException(message, ExceptionType.DELETE, ex);
    }

    public static StarActivityInMoviesException createUpdateException(String message, Exception ex) {
        return new StarActivityInMoviesException(message, ExceptionType.UPDATE, ex);
    }

    public static StarActivityInMoviesException createSelectException(String message, Exception ex) {
        return new StarActivityInMoviesException(message, ExceptionType.SELECT, ex);
    }
}

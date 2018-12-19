package academy.softserve.movieuniverse.exception;

public class StarException extends CustomValidationException {

    private static final long serialVersionUID = 1L;

    private StarException(String customMessage, ExceptionType exceptionType, Exception ex) {
        super(customMessage, exceptionType, ex);
    }

    public static StarException createDeleteException(String message, Exception ex) {
        return new StarException(message, ExceptionType.DELETE, ex);
    }

    public static StarException createSaveException(String message, Exception ex) {
        return new StarException(message, ExceptionType.SAVE, ex);
    }

    public static StarException createSelectException(String message, Exception ex) {
        return new StarException(message, ExceptionType.SELECT, ex);
    }

    public static StarException createUpdateException(String message, Exception ex) {
        return new StarException(message, ExceptionType.UPDATE, ex);
    }
}

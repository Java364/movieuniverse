package academy.softserve.movieuniverse.exception;

public class StarProfessionException extends CustomValidationException {

    private static final long serialVersionUID = 1646215947109824314L;

    private StarProfessionException(String customMessage, ExceptionType exceptionType, Exception ex) {
        super(customMessage, exceptionType, ex);
    }

    public static StarProfessionException createSaveException(String message, Exception ex) {
        return new StarProfessionException(message, ExceptionType.SAVE, ex);
    }

    public static StarProfessionException createDeleteException(String message, Exception ex) {
        return new StarProfessionException(message, ExceptionType.DELETE, ex);
    }

    public static StarProfessionException createUpdateException(String message, Exception ex) {
        return new StarProfessionException(message, ExceptionType.UPDATE, ex);
    }

    public static StarProfessionException createSelectException(String message, Exception ex) {
        return new StarProfessionException(message, ExceptionType.SELECT, ex);
    }
}

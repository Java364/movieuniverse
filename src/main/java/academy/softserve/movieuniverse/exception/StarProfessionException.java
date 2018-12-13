package academy.softserve.movieuniverse.exception;

import academy.softserve.movieuniverse.entity.StarProfession;

public class StarProfessionException extends CustomValidationException {

    private StarProfessionException(String customMessage, ExceptionType exceptionType, Exception ex) {
        super(customMessage, exceptionType, ex);
    }

    public static StarProfessionException createSaveException(String message, Exception ex) {
        return new StarProfessionException(message, ExceptionType.SAVE, ex);
    }

    public static StarProfessionException createDeleteException(String message, Exception ex) {
        return new StarProfessionException(message, ExceptionType.DELETE, ex);
    }

    public static StarProfessionException createUpdateException (String message, Exception ex) {
        return new StarProfessionException(message, ExceptionType.UPDATE, ex);
    }

    public static StarProfessionException createSelectException (String message, Exception ex) {
        return new StarProfessionException(message, ExceptionType.SELECT, ex);
    }
}

package academy.softserve.movieuniverse.exception;


public class ProfessionException extends CustomValidationException {


    public ProfessionException(String customMessage, ExceptionType exceptionType, Exception ex) {
        super(customMessage, exceptionType, ex);
    }

    public static ProfessionException createDeleteException(String message, Exception ex) {
        return new ProfessionException(message, ExceptionType.DELETE, ex);
    }

    public static ProfessionException createSaveException(String message, Exception ex) {
        return new ProfessionException(message, ExceptionType.SAVE, ex);
    }

    public static ProfessionException createSelectException(String message, Exception ex) {
        return new ProfessionException(message, ExceptionType.SELECT, ex);
    }

    public static ProfessionException createUpdateException(String message, Exception ex) {
        return new ProfessionException(message, ExceptionType.UPDATE, ex);
    }
}

package academy.softserve.movieuniverse.exception;

public class UserException extends CustomValidationException {

    private UserException(String customMessage, ExceptionType exceptionType, Exception ex) {
        super(customMessage, exceptionType, ex);
    }

    public static UserException createSaveException(String message, Exception ex) {
        return new UserException(message, ExceptionType.SAVE, ex);
    }

    public static UserException createSelectException(String message, Exception ex) {
        return new UserException(message, ExceptionType.SELECT, ex);
    }

    public static UserException createUpdateException(String message, Exception ex) {
        return new UserException(message, ExceptionType.UPDATE, ex);
    }

    public static UserException createDeleteException(String message, Exception ex) {
        return new UserException(message, ExceptionType.DELETE, ex);
    }
}

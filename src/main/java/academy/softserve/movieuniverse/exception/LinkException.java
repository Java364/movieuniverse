package academy.softserve.movieuniverse.exception;


public class LinkException extends CustomValidationException {


    public LinkException(String customMessage, ExceptionType exceptionType, Exception ex) {
        super(customMessage, exceptionType, ex);
    }

    public static LinkException createDeleteException(String message, Exception ex) {
        return new LinkException(message, ExceptionType.DELETE, ex);
    }

    public static LinkException createSaveException(String message, Exception ex) {
        return new LinkException(message, ExceptionType.SAVE, ex);
    }

    public static LinkException createSelectException(String message, Exception ex) {
        return new LinkException(message, ExceptionType.SELECT, ex);
    }

    public static LinkException createUpdateException(String message, Exception ex) {
        return new LinkException(message, ExceptionType.UPDATE, ex);
    }

}

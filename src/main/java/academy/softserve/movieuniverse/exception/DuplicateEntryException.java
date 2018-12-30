package academy.softserve.movieuniverse.exception;

public class DuplicateEntryException extends CustomValidationException {
    public DuplicateEntryException(String message) {
        super(message);
    }

   /* public DuplicateEntryException(String message, ExceptionType exceptionType, Exception ex) {
        super(message, exceptionType, ex);
    }*/
}

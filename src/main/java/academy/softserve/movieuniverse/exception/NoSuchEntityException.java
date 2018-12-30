package academy.softserve.movieuniverse.exception;

public class NoSuchEntityException extends CustomValidationException {
    public NoSuchEntityException(String message) {
        super(message);
    }

   /* public NoSuchEntityException(String message, ExceptionType exceptionType, Exception ex) {
        super(message, exceptionType, ex);
    }*/
}

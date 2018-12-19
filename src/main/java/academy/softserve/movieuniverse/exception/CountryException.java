package academy.softserve.movieuniverse.exception;

public class CountryException extends CustomValidationException {

    private static final long serialVersionUID = -6283677404347365061L;

    private CountryException(String customMessage, ExceptionType exceptionType, Exception ex) {
        super(customMessage, exceptionType, ex);
    }

    public static CountryException createSaveException(String message, Exception ex) {
        return new CountryException(message, ExceptionType.SAVE, ex);
    }

    public static CountryException createDeleteException(String message, Exception ex) {
        return new CountryException(message, ExceptionType.DELETE, ex);
    }

    public static CountryException createUpdateException(String message, Exception ex) {
        return new CountryException(message, ExceptionType.UPDATE, ex);
    }

    public static CountryException createSelectException(String message, Exception ex) {
        return new CountryException(message, ExceptionType.SELECT, ex);
    }

}

package academy.softserve.movieuniverse.exception;

public class CountryException extends CustomValidationException {

    private static final long serialVersionUID = -6283677404347365061L;

    private CountryException(String customMessage) {
        super(customMessage);
    }

    public static CountryException createSaveException(String message) {
        return new CountryException(message);
    }

    public static CountryException createDeleteException(String message) {
        return new CountryException(message);
    }

    public static CountryException createUpdateException(String message) {
        return new CountryException(message);
    }

    public static CountryException createSelectException(String message) {
        return new CountryException(message);
    }

}

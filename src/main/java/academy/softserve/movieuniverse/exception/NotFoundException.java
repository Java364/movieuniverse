package academy.softserve.movieuniverse.exception;

public class NotFoundException extends CustomValidationException {

    public NotFoundException(String customMessage) {
        super(customMessage);
    }

    public static NotFoundException createDeleteException(String message) {
        return new NotFoundException(message);
    }

    public static NotFoundException createSaveException(String message) {
        return new NotFoundException(message);
    }

    public static NotFoundException createSelectException(String message) {
        return new NotFoundException(message);
    }

    public static NotFoundException createUpdateException(String message) {
        return new NotFoundException(message);
    }

}

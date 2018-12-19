package academy.softserve.movieuniverse.exception;


public class ProfessionException extends CustomValidationException {


    public ProfessionException(String customMessage) {
        super(customMessage);
    }

    public static ProfessionException createDeleteException(String message) {
        return new ProfessionException(message);
    }

    public static ProfessionException createSaveException(String message) {
        return new ProfessionException(message);
    }

    public static ProfessionException createSelectException(String message) {
        return new ProfessionException(message);
    }

    public static ProfessionException createUpdateException(String message) {
        return new ProfessionException(message);
    }
}

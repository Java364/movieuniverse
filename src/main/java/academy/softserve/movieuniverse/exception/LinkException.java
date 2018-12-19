package academy.softserve.movieuniverse.exception;


public class LinkException extends CustomValidationException {


    public LinkException(String customMessage) {
        super(customMessage);
    }

    public static LinkException createDeleteException(String message) {
        return new LinkException(message);
    }

    public static LinkException createSaveException(String message) {
        return new LinkException(message);
    }

    public static LinkException createSelectException(String message) {
        return new LinkException(message);
    }

    public static LinkException createUpdateException(String message) {
        return new LinkException(message);
    }

}

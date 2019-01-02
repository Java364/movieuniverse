package academy.softserve.movieuniverse.exception;

public class NotFoundException extends CustomValidationException {

    public NotFoundException(String customMessage) {
        super(customMessage);
    }

    /*
     * public static NotFoundException createNotFoundException(String message) { return new NotFoundException(message);
     * }
     */

}

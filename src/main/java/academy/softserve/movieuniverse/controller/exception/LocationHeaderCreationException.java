package academy.softserve.movieuniverse.controller.exception;

public class LocationHeaderCreationException extends ControllerException {
    public LocationHeaderCreationException(String message) {
        super(message);
    }

    public LocationHeaderCreationException(String message, Throwable cause) {
        super(message, cause);
    }
}

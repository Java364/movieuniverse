package academy.softserve.movieuniverse.exception;

public class DuplicateEntryException extends RuntimeException {
    private String className;

    public DuplicateEntryException(String message) {
        super(message);
    }

    public DuplicateEntryException(String message, Throwable cause) {
        super(message, cause);
    }

    public static String createMsg(String message, Class clazz) {
        return clazz.getSimpleName() + ": " + message;
    }
}

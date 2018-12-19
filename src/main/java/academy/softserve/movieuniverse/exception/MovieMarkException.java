package academy.softserve.movieuniverse.exception;

public class MovieMarkException extends CustomValidationException {

    private static final long serialVersionUID = -9023090121189027086L;

    public MovieMarkException(String message, ExceptionType exceptionType, Exception ex) {
        super(message, exceptionType, ex);
    }

    public static MovieMarkException createSaveException(String message, Exception ex) {
        return new MovieMarkException(message, ExceptionType.SAVE, ex);
    }

    public static MovieMarkException createUpdateException(String message, Exception ex) {
        return new MovieMarkException(message, ExceptionType.UPDATE, ex);
    }

    public static MovieMarkException createDeleteException(String message, Exception ex) {
        return new MovieMarkException(message, ExceptionType.DELETE, ex);
    }

    public static MovieMarkException createSelectException(String message, Exception ex) {
        return new MovieMarkException(message, ExceptionType.SELECT, ex);
    }
}

package academy.softserve.movieuniverse.exception;

public class UserReviewMarkException extends CustomValidationException {
    private static final long serialVersionUID = 1L;

    public UserReviewMarkException(String customMessage, ExceptionType exceptionType, Exception ex) {
        super(customMessage, exceptionType, ex);
    }

    public static UserReviewMarkException createSaveException(String message, Exception ex) {
        return new UserReviewMarkException(message, ExceptionType.SAVE, ex);
    }

    public static UserReviewMarkException createDeleteException(String message, Exception ex) {
        return new UserReviewMarkException(message, ExceptionType.DELETE, ex);
    }

    public static UserReviewMarkException createSelectException(String message, Exception ex) {
        return new UserReviewMarkException(message, ExceptionType.SELECT, ex);
    }

    public static UserReviewMarkException createUpdateException(String message, Exception ex) {
        return new UserReviewMarkException(message, ExceptionType.UPDATE, ex);
    }
}

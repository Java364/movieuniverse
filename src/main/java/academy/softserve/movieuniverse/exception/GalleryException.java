package academy.softserve.movieuniverse.exception;

public class GalleryException extends CustomValidationException {

    private static final long serialVersionUID = 1L;

    private GalleryException(String customMessage, ExceptionType exceptionType, Exception ex) {
        super(customMessage, exceptionType, ex);
    }

    public static GalleryException createDeleteException(String message, Exception ex) {
        return new GalleryException(message, ExceptionType.DELETE, ex);
    }

    public static GalleryException createSaveException(String message, Exception ex) {
        return new GalleryException(message, ExceptionType.SAVE, ex);
    }

    public static GalleryException createSelectException(String message, Exception ex) {
        return new GalleryException(message, ExceptionType.SELECT, ex);
    }

    public static GalleryException createUpdateException(String message, Exception ex) {
        return new GalleryException(message, ExceptionType.UPDATE, ex);
    }

}

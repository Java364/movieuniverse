package academy.softserve.movieuniverse.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<Object> notFoundLink(CustomValidationException ex) {
        ApiError apiError = new ApiError(NOT_FOUND);
        apiError.setMessage(ex.getCustomMessage());
        return buildResponseEntity(apiError);
    }

    /*@ExceptionHandler(ProfessionException.class)
    protected ResponseEntity<Object> notFoundProfession(CustomValidationException ex) {
        ApiError apiError = new ApiError(NOT_FOUND);
        apiError.setMessage(ex.getCustomMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(StarException.class)
    protected ResponseEntity<Object> notFoundStar(CustomValidationException ex) {
        ApiError apiError = new ApiError(NOT_FOUND);
        apiError.setMessage(ex.getCustomMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(CountryException.class)
    protected ResponseEntity<Object> notFoundCountry(CustomValidationException ex) {
        ApiError apiError = new ApiError(NOT_FOUND);
        apiError.setMessage(ex.getCustomMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(MovieMarkException.class)
    protected ResponseEntity<Object> notFoundMovieMark(CustomValidationException ex) {
        ApiError apiError = new ApiError(NOT_FOUND);
        apiError.setMessage(ex.getCustomMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(GalleryException.class)
    protected ResponseEntity<Object> notFoundGallery(CustomValidationException ex) {
        ApiError apiError = new ApiError(NOT_FOUND);
        apiError.setMessage(ex.getCustomMessage());
        return buildResponseEntity(apiError);
    }*/

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}
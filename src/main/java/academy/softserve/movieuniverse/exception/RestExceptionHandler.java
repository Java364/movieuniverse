package academy.softserve.movieuniverse.exception;


import academy.softserve.movieuniverse.entity.Profession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class RestExceptionHandler {
    /*@ResponseStatus(value= HttpStatus.NOT_FOUND,
            reason="no!!!!!!!!")*/
    @ExceptionHandler(LinkException.class)
    protected ResponseEntity<Object> notFoundLink(
            CustomValidationException ex) {
        ApiError apiError = new ApiError(NOT_FOUND);
        apiError.setMessage(ex.getCustomMessage());
        return buildResponseEntity(apiError);
    }

    @ExceptionHandler(ProfessionException.class)
    protected ResponseEntity<Object> notFoundProfession(
            CustomValidationException ex) {
        ApiError apiError = new ApiError(NOT_FOUND);
        apiError.setMessage(ex.getCustomMessage());
        return buildResponseEntity(apiError);
    }
    
    @ExceptionHandler(StarException.class)
    protected ResponseEntity<Object> notFoundStar(
            CustomValidationException ex) {
        ApiError apiError = new ApiError(NOT_FOUND);
        apiError.setMessage(ex.getCustomMessage());
        return buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

}
package fr.lescrous.escr.exceptions;

import fr.lescrous.escr.response.GenericErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.util.WebUtils;

import javax.persistence.NoResultException;

/**
 * The type Global exception handler.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle exception response entity.
     *
     * @param ex      the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler({NoResultException.class})
    public final ResponseEntity<GenericErrorResponse> handleException(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.NOT_FOUND;
        StudentNotFoundException e = new StudentNotFoundException(ex.getMessage(), ex);
        return handleStudentNotFoundException( e, headers, status, request);
    }

    /**
     * Handle non cactched exception response entity.
     *
     * @param ex      the ex
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler({UnknownTechnicalException.class})
    public final ResponseEntity<GenericErrorResponse> handleNonCactchedException(UnknownTechnicalException ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        GenericErrorResponse r = new GenericErrorResponse();
        r.setError("Server issues");
        r.setError("The server has encountered technical issues.");
        r.setErrorUri("https://router.europeanstudentcard.eu/api-doc");
        return handleExceptionInternal(ex, null, headers, status, request);
    }

    /**
     * Handle student not found exception response entity.
     *
     * @param ex      the ex
     * @param headers the headers
     * @param status  the status
     * @param request the request
     * @return the response entity
     */
    protected ResponseEntity<GenericErrorResponse> handleStudentNotFoundException(StudentNotFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        GenericErrorResponse r = new GenericErrorResponse();
        r.setError("card_not_found");
        r.setErrorDescription("Card doesn't exists");
        r.setErrorUri("https://router.europeanstudentcard.eu/api-doc");
        return handleExceptionInternal(ex, r, headers, status, request);
    }

    /**
     * Handle exception internal response entity.
     *
     * @param ex      the ex
     * @param body    the body
     * @param headers the headers
     * @param status  the status
     * @param request the request
     * @return the response entity
     */
    protected ResponseEntity<GenericErrorResponse> handleExceptionInternal(Exception ex, GenericErrorResponse body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }

        return new ResponseEntity<>(body, headers, status);
    }

}

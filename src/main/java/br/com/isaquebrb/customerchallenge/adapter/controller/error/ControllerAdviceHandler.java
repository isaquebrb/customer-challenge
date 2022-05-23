package br.com.isaquebrb.customerchallenge.adapter.controller.error;

import br.com.isaquebrb.customerchallenge.adapter.presenter.response.StandardErrorResponse;
import br.com.isaquebrb.customerchallenge.core.exception.NotFoundException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class ControllerAdviceHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<StandardErrorResponse> handleDataIntegrity(DataIntegrityViolationException ex) {
        log.error("Error to save on database.", ex);

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String title = "Error to save on database.";
        String message = ex.getMessage();

        if (ex.getCause() instanceof ConstraintViolationException exConstraint) {
            message = exConstraint.getSQLException().getMessage();
        }

        return new ResponseEntity<>(new StandardErrorResponse(status.value(), title, message), status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<StandardErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        log.error("Error to validate fields.", ex);

        HttpStatus status = HttpStatus.BAD_REQUEST;
        String title = "Error to validate fields.";
        String message = ex
                .getBindingResult()
                .getFieldErrors().stream()
                .map(e -> "Field [" + e.getField() + "] " + e.getDefaultMessage() + ".")
                .collect(Collectors.joining(" "));

        return new ResponseEntity<>(new StandardErrorResponse(status.value(), title, message), status);
    }

    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<StandardErrorResponse> handleNotFound(NotFoundException ex) {
        log.error("Error to found object.", ex);

        HttpStatus status = HttpStatus.NOT_FOUND;
        String title = "Error to found object.";
        String message = ex.getMessage();

        return new ResponseEntity<>(new StandardErrorResponse(status.value(), title, message), status);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<StandardErrorResponse> handleHttpNotReadable(HttpMessageNotReadableException ex) {
        log.error("Invalid attribute type.", ex);

        HttpStatus status = HttpStatus.BAD_REQUEST;
        String title = "Invalid attribute type.";
        String message = ex.getMessage();

        if (ex.getCause() instanceof InvalidFormatException exInvalid) {
            message = exInvalid.getOriginalMessage();
        }

        return new ResponseEntity<>(new StandardErrorResponse(status.value(), title, message), status);
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<StandardErrorResponse> handleGenericException(Exception ex) {
        log.error("Generic error.", ex);

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String title = "Generic error.";
        String message = ex.getMessage();

        return new ResponseEntity<>(new StandardErrorResponse(status.value(), title, message), status);
    }
}

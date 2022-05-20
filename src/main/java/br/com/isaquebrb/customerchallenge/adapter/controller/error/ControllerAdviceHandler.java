package br.com.isaquebrb.customerchallenge.adapter.controller.error;

import br.com.isaquebrb.customerchallenge.adapter.presenter.response.StandardErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private ResponseEntity<StandardErrorResponse> handleMethodArgumentNotValit(MethodArgumentNotValidException ex) {
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
}

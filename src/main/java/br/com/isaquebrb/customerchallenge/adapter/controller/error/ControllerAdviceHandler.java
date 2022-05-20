package br.com.isaquebrb.customerchallenge.adapter.controller.error;

import br.com.isaquebrb.customerchallenge.adapter.presenter.error.StandardError;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerAdviceHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<StandardError> handleDataIntegrity(DataIntegrityViolationException ex) {
        log.error("Error to save on database.", ex);

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        String title = "Error to save on database.";
        String message = ex.getMessage();

        if (ex.getCause() instanceof ConstraintViolationException exConstraint) {
            message = exConstraint.getSQLException().getMessage();
        }

        return new ResponseEntity<>(new StandardError(status.value(), title, message), status);
    }
}

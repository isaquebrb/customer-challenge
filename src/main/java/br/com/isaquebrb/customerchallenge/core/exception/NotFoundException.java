package br.com.isaquebrb.customerchallenge.core.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String entityName, Long id) {
        super(String.format("%s id %s not found.", entityName, id));
    }
}

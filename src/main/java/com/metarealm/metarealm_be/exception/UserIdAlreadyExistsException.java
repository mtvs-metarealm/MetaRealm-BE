package com.metarealm.metarealm_be.exception;

public class UserIdAlreadyExistsException extends RuntimeException {

    public UserIdAlreadyExistsException(String message) {
        super(message);
    }
}
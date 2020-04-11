package com.srufanov.socialnetwork.userservice.exception;

public class AuthenticationException extends UserServiceException {

    public AuthenticationException() {
    }

    public AuthenticationException(String message) {
        super(message);
    }

    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

}

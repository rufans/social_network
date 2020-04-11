package com.srufanov.socialnetwork.userservice.exception;

public class UserServiceException extends RuntimeException {

    public UserServiceException() {
    }

    public UserServiceException(String message) {
        super(message);
    }

    public UserServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}

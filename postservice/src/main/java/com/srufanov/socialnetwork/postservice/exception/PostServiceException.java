package com.srufanov.socialnetwork.postservice.exception;

public class PostServiceException extends RuntimeException {

    public PostServiceException() {
    }

    public PostServiceException(String message) {
        super(message);
    }

    public PostServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}

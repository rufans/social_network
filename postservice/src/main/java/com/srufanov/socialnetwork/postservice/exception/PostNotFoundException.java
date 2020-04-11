package com.srufanov.socialnetwork.postservice.exception;

public class PostNotFoundException extends PostServiceException {

    public PostNotFoundException() {
    }

    public PostNotFoundException(String message) {
        super(message);
    }

    public PostNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}

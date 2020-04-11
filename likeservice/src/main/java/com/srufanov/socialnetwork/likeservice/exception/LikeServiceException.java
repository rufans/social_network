package com.srufanov.socialnetwork.likeservice.exception;

public class LikeServiceException extends RuntimeException {

    public LikeServiceException() {
    }

    public LikeServiceException(String message) {
        super(message);
    }

    public LikeServiceException(String message, Throwable cause) {
        super(message, cause);
    }

}

package com.srufanov.socialnetwork.userservice.exception;

public class FriendshipNotFoundException extends UserServiceException {

    public FriendshipNotFoundException() {
    }

    public FriendshipNotFoundException(String message) {
        super(message);
    }

    public FriendshipNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}

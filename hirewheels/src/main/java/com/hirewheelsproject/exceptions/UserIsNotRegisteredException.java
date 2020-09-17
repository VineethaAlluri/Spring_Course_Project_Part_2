package com.hirewheelsproject.exceptions;

public class UserIsNotRegisteredException extends Exception{

    public UserIsNotRegisteredException(String message) {
        super(message);
    }

    public UserIsNotRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserIsNotRegisteredException(Throwable cause) {
        super(cause);
    }

    public UserIsNotRegisteredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

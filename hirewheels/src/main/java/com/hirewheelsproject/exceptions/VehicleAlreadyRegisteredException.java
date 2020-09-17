package com.hirewheelsproject.exceptions;

public class VehicleAlreadyRegisteredException extends Exception{

    public VehicleAlreadyRegisteredException(String message) {
        super(message);
    }

    public VehicleAlreadyRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public VehicleAlreadyRegisteredException(Throwable cause) {
        super(cause);
    }

    public VehicleAlreadyRegisteredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

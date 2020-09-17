package com.hirewheelsproject.exceptions;

public class NoVehicleAvailableException extends Exception {

    public NoVehicleAvailableException(String message) {
        super(message);
    }

    public NoVehicleAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoVehicleAvailableException(Throwable cause) {
        super(cause);
    }

    public NoVehicleAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

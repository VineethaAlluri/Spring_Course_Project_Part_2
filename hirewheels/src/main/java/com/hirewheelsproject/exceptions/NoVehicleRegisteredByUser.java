package com.hirewheelsproject.exceptions;

public class NoVehicleRegisteredByUser extends Exception{

    public NoVehicleRegisteredByUser(String message) {
        super(message);
    }

    public NoVehicleRegisteredByUser(String message, Throwable cause) {
        super(message, cause);
    }

    public NoVehicleRegisteredByUser(Throwable cause) {
        super(cause);
    }

    public NoVehicleRegisteredByUser(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

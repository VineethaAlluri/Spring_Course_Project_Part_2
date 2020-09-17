package com.hirewheelsproject.exceptions;

public class NoVehicleRegisteredException extends Exception{
    public NoVehicleRegisteredException(String message) {
        super(message);
    }

    public NoVehicleRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public  NoVehicleRegisteredException(Throwable cause) {
        super(cause);
    }

    public  NoVehicleRegisteredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

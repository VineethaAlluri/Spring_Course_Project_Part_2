package com.hirewheelsproject.aspects;

import com.hirewheelsproject.responses.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class CustomExceptionAspect {
    @ExceptionHandler(com.hirewheelsproject.exceptions.InsufficientBalanceException.class)
    public ResponseEntity<CustomResponse> handleInsufficientBalanceException(Exception e) {
        CustomResponse response = new CustomResponse(new Date(), e.getMessage(), HttpStatus.EXPECTATION_FAILED.value());
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(com.hirewheelsproject.exceptions.NoVehicleAvailableException.class)
    public ResponseEntity<CustomResponse> handleNoVehicleAvailableException(Exception e) {
        CustomResponse response = new CustomResponse(new Date(), e.getMessage(), HttpStatus.EXPECTATION_FAILED.value());
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(com.hirewheelsproject.exceptions.NoVehicleRegisteredByUser.class)
    public ResponseEntity<CustomResponse> handleNoVehicleRegisteredByUser(Exception e) {
        CustomResponse response = new CustomResponse(new Date(), e.getMessage(), HttpStatus.EXPECTATION_FAILED.value());
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(com.hirewheelsproject.exceptions.NoVehicleRegisteredException.class)
    public ResponseEntity<CustomResponse> handleNoVehicleRegisteredException(Exception e) {
        CustomResponse response = new CustomResponse(new Date(), e.getMessage(), HttpStatus.EXPECTATION_FAILED.value());
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(com.hirewheelsproject.exceptions.UnauthorizedUserException.class)
    public ResponseEntity<CustomResponse> handleUnauthorizedUserException(Exception e) {
        CustomResponse response = new CustomResponse(new Date(),"Invalid Credentials", HttpStatus.EXPECTATION_FAILED.value());
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(com.hirewheelsproject.exceptions.UserAlreadyExistsException.class)
    public ResponseEntity<CustomResponse> handleUserAlreadyExistsException(Exception e) {
        CustomResponse response = new CustomResponse(new Date(), e.getMessage(), HttpStatus.EXPECTATION_FAILED.value());
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(com.hirewheelsproject.exceptions.UserIsNotRegisteredException.class)
    public ResponseEntity<CustomResponse> handleUserIsNotRegisteredException(Exception e) {
        CustomResponse response = new CustomResponse(new Date(), "User Not Registered", HttpStatus.EXPECTATION_FAILED.value());
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(com.hirewheelsproject.exceptions.VehicleAlreadyRegisteredException.class)
    public ResponseEntity<CustomResponse> handleVehicleAlreadyRegisteredException(Exception e) {
        CustomResponse response = new CustomResponse(new Date(), e.getMessage(), HttpStatus.EXPECTATION_FAILED.value());
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }
}

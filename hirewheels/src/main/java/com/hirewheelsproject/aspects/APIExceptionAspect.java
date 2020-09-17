package com.hirewheelsproject.aspects;

import com.hirewheelsproject.responses.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class APIExceptionAspect {

    @ExceptionHandler(com.hirewheelsproject.exceptions.APIException.class)
    public ResponseEntity<CustomResponse> handleAPIException(Exception e) {
        CustomResponse response = new CustomResponse(new Date(), e.getMessage(), HttpStatus.EXPECTATION_FAILED.value());
        return new ResponseEntity<>(response, HttpStatus.EXPECTATION_FAILED);
    }
}

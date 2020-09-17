package com.hirewheelsproject.validators;

import com.hirewheelsproject.exceptions.APIException;

import java.util.Date;

public interface VehicleValidator {
    public void validateAvailableVehicles(Date pickUpDate, Date dropDate) throws APIException;
}

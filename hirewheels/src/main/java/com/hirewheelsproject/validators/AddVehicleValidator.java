package com.hirewheelsproject.validators;

import com.hirewheelsproject.dtos.AddVehicleDTO;
import com.hirewheelsproject.exceptions.APIException;

public interface AddVehicleValidator {
    public void validateAddVehicle(AddVehicleDTO addVehicleDTO) throws APIException;
}

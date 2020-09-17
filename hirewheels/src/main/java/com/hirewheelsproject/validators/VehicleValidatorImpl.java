package com.hirewheelsproject.validators;

import com.hirewheelsproject.exceptions.APIException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("vehicleValidatorImpl")
public class VehicleValidatorImpl implements VehicleValidator{
    public void validateAvailableVehicles(Date pickUpDate, Date dropDate) throws APIException {
        if(dropDate.before(pickUpDate) || dropDate.before(new Date()))
            throw new APIException("Drop-off date should be greater than today's " +
                    "date and greater than the pickup date");
        if(pickUpDate.before(new Date()))
            throw new APIException("Pickup date should not be less than today's date");
    }
}

package com.hirewheelsproject.validators;

import com.hirewheelsproject.dtos.BookingDTO;
import com.hirewheelsproject.exceptions.APIException;

public interface BookingValidator {
    public void validateBookingDTO(BookingDTO bookingDTO);
}

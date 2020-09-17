package com.hirewheelsproject.validators;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import com.hirewheelsproject.dtos.BookingDTO;
import com.hirewheelsproject.exceptions.APIException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("bookingValidatorImpl")
public class BookingValidatorImpl implements BookingValidator{
    @Override
    public void validateBookingDTO(BookingDTO bookingDTO) {
    }
}

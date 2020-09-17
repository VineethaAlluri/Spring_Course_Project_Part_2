package com.hirewheelsproject.controllers;

import com.hirewheelsproject.dtos.BookingDTO;
import com.hirewheelsproject.dtos.UserSignUpDTO;
import com.hirewheelsproject.entities.Booking;
import com.hirewheelsproject.entities.Users;
import com.hirewheelsproject.exceptions.APIException;
import com.hirewheelsproject.exceptions.InsufficientBalanceException;
import com.hirewheelsproject.exceptions.UserAlreadyExistsException;
import com.hirewheelsproject.responses.CustomResponse;
import com.hirewheelsproject.services.BookingService;
import com.hirewheelsproject.services.UserService;
import com.hirewheelsproject.utils.DTOEntityConverter;
import com.hirewheelsproject.utils.EntityDTOConverter;
import com.hirewheelsproject.validators.BookingValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller("bookingController")
public class BookingController {

    @Autowired @Qualifier("bookingValidatorImpl")
    private BookingValidator bookingValidator;

    @Autowired @Qualifier("DTOEntityConverter")
    private DTOEntityConverter dtoEntityConverter;

    @Autowired @Qualifier("entityDTOConverter")
    private EntityDTOConverter entityDTOConverter;

    @Autowired @Qualifier("bookingServiceImpl")
    private BookingService bookingService;

    @RequestMapping(method = RequestMethod.POST, value = "/bookings")
    @ResponseBody
    public ResponseEntity addBookings(@RequestBody BookingDTO bookingDTO) throws APIException , InsufficientBalanceException {
        ResponseEntity responseEntity = null;
        bookingValidator.validateBookingDTO(bookingDTO);
        Booking booking = dtoEntityConverter.bookingDTOtoBooking(bookingDTO);
        Booking savedBooking = null;
        savedBooking = bookingService.addBooking(booking);
        if(savedBooking != null){
            BookingDTO bookingDTO1 = entityDTOConverter.bookingToBookingDTOConverter(savedBooking);
            responseEntity = new ResponseEntity(bookingDTO1, HttpStatus.CREATED);
        }
        return responseEntity;
    }

}

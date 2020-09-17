package com.hirewheelsproject.services;


import com.hirewheelsproject.entities.Booking;
import com.hirewheelsproject.exceptions.InsufficientBalanceException;

public interface BookingService {
    public Booking addBooking(Booking booking) throws InsufficientBalanceException;
}

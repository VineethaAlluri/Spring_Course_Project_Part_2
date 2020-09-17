package com.hirewheelsproject.utils;

import com.hirewheelsproject.dtos.BookingDTO;
import com.hirewheelsproject.dtos.UserLoginResultDTO;
import com.hirewheelsproject.dtos.UserSignUpDTO;
import com.hirewheelsproject.entities.Booking;
import com.hirewheelsproject.entities.Users;
import org.springframework.stereotype.Service;

@Service("entityDTOConverter")
public class EntityDTOConverter {

    public UserSignUpDTO usersToUserSignUpDTOConverter(Users users) {
        UserSignUpDTO userSignUpDTO = new UserSignUpDTO();
        userSignUpDTO.setFirstName(users.getFirstName());
        userSignUpDTO.setLastName(users.getLastName());
        userSignUpDTO.setEmail(users.getEmail());
        userSignUpDTO.setPassword(users.getPassword());
        userSignUpDTO.setMobileNumber(users.getMobileNumber());
        return userSignUpDTO;
    }

    public UserLoginResultDTO usersToUserLoginResultDTOConverter(Users users) {
        UserLoginResultDTO userLoginResultDTO = new UserLoginResultDTO();
        userLoginResultDTO.setEmail(users.getEmail());
        userLoginResultDTO.setFirstName(users.getFirstName());
        userLoginResultDTO.setId(users.getId());
        userLoginResultDTO.setLastName(users.getLastName());
        userLoginResultDTO.setMobileNumber(users.getMobileNumber());
        userLoginResultDTO.setRoleName(users.getRole().getName());
        userLoginResultDTO.setWalletMoney(users.getWalletMoney());

        return userLoginResultDTO;
    }

    public BookingDTO bookingToBookingDTOConverter(Booking booking) {
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setAmount(booking.getAmount());
        bookingDTO.setId(booking.getId());
        bookingDTO.setBookingDate(booking.getBookingDate());
        bookingDTO.setDropOffDate(booking.getDropOffDate());
        bookingDTO.setLocationId(booking.getLocation().getId());
        bookingDTO.setPickUpDate(booking.getPickUpDate());
        bookingDTO.setUsersId(booking.getUsers().getId());
        bookingDTO.setVehicleId(booking.getVehicle().getId());

        return bookingDTO;
    }
}

package com.hirewheelsproject.services.serviceImpl;

import com.hirewheelsproject.daos.BookingDAO;
import com.hirewheelsproject.daos.UsersDAO;
import com.hirewheelsproject.entities.Booking;
import com.hirewheelsproject.entities.Users;
import com.hirewheelsproject.exceptions.InsufficientBalanceException;
import com.hirewheelsproject.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("bookingServiceImpl")
public class BookingServiceImpl implements BookingService {

    @Autowired @Qualifier("bookingDAO")
    private BookingDAO bookingDAO;

    @Autowired @Qualifier("usersDAO")
    private UsersDAO usersDAO;

    @Override
    public Booking addBooking(Booking booking) throws InsufficientBalanceException {
        Users users = booking.getUsers();
        System.out.println(users);
        if(users.getWalletMoney() > booking.getAmount()) {
            users.setWalletMoney(users.getWalletMoney()-booking.getAmount());
            usersDAO.save(users);
            bookingDAO.save(booking);
        }
        else {
          throw new InsufficientBalanceException("Insufficient Balance. Please Check With Admin");
        }
        return booking;
    }
}

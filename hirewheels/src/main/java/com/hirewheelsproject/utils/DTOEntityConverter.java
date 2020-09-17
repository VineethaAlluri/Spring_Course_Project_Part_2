package com.hirewheelsproject.utils;

import com.hirewheelsproject.daos.*;
import com.hirewheelsproject.dtos.AddVehicleDTO;
import com.hirewheelsproject.dtos.BookingDTO;
import com.hirewheelsproject.dtos.UserLoginDTO;
import com.hirewheelsproject.dtos.UserSignUpDTO;
import com.hirewheelsproject.entities.Booking;
import com.hirewheelsproject.entities.Users;
import com.hirewheelsproject.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("DTOEntityConverter")
public class DTOEntityConverter {

    @Autowired @Qualifier("roleDAO")
    private RoleDAO roleDAO;

    @Autowired @Qualifier("fuelTypeDAO")
    private FuelTypeDAO fuelTypeDAO;

    @Autowired @Qualifier("locationDAO")
    private LocationDAO locationDAO;

    @Autowired @Qualifier("vehicleDAO")
    private VehicleDAO vehicleDAO;

    @Autowired @Qualifier("usersDAO")
    private UsersDAO usersDAO;

    @Autowired @Qualifier("vehicleSubCategoryDAO")
    private VehicleSubCategoryDAO vehicleSubCategoryDAO;

    public Users userSignUpDTOtoUsersConverter(UserSignUpDTO userSignUpDTO) {
        Users users = new Users();
        users.setRole(roleDAO.findByName("User"));
        users.setWalletMoney(10000.00);
        users.setFirstName(userSignUpDTO.getFirstName());
        users.setLastName(userSignUpDTO.getLastName());
        users.setEmail(userSignUpDTO.getEmail());
        users.setPassword(userSignUpDTO.getPassword());
        users.setMobileNumber(userSignUpDTO.getMobileNumber());

        return users;
    }

    public Users userLoginDTOtoUsersConvertor(UserLoginDTO userLoginDTO) {
        Users users = new Users();
        users.setEmail(userLoginDTO.getEmail());
        users.setPassword(userLoginDTO.getPassword());

        return users;
    }

    public Vehicle addVehicleDTOtoVehicleConverter(AddVehicleDTO addVehicleDTO) {
        Vehicle vehicle = new Vehicle();
        vehicle.setAvailabilityStatus(addVehicleDTO.getAvailabilityStatus());
        vehicle.setColor(addVehicleDTO.getColor());
        vehicle.setFuelType(fuelTypeDAO.findById(addVehicleDTO.getFuelTypeId()));
        vehicle.setVehicleImageUrl(addVehicleDTO.getVehicleImageUrl());
        vehicle.setLocation(locationDAO.findById(addVehicleDTO.getLocationId()));
        vehicle.setVehicleModel(addVehicleDTO.getVehicleModel());
        vehicle.setVehicleNumber(addVehicleDTO.getVehicleNumber());
        vehicle.setVehicleSubCategory(vehicleSubCategoryDAO.findById(addVehicleDTO.getVehicleSubCategoryId()));

        return vehicle;
    }

    public Booking bookingDTOtoBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setAmount(bookingDTO.getAmount());
        booking.setBookingDate(bookingDTO.getBookingDate());
        booking.setDropOffDate(bookingDTO.getDropOffDate());
        booking.setLocation(locationDAO.findById(bookingDTO.getLocationId()));
        booking.setPickUpDate(bookingDTO.getPickUpDate());
        booking.setUsers(usersDAO.findById(bookingDTO.getUsersId()));
        booking.setVehicle(vehicleDAO.findById(bookingDTO.getVehicleId()));

        return booking;
    }
}

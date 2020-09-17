package com.hirewheelsproject.services.serviceImpl;

import com.hirewheelsproject.daos.BookingDAO;
import com.hirewheelsproject.daos.UsersDAO;
import com.hirewheelsproject.daos.VehicleDAO;
import com.hirewheelsproject.entities.Booking;
import com.hirewheelsproject.entities.Users;
import com.hirewheelsproject.entities.Vehicle;
import com.hirewheelsproject.exceptions.NoVehicleAvailableException;
import com.hirewheelsproject.exceptions.NoVehicleRegisteredByUser;
import com.hirewheelsproject.exceptions.NoVehicleRegisteredException;
import com.hirewheelsproject.services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("vehicleServiceImpl")
public class VehicleServiceImpl implements VehicleService {

    @Autowired @Qualifier("vehicleDAO")
    private VehicleDAO vehicleDAO;

    @Autowired @Qualifier("usersDAO")
    private UsersDAO usersDAO;

    @Autowired @Qualifier("bookingDAO")
    private BookingDAO bookingDAO;

    @Override
    public List<Vehicle> getAllVehicles() throws NoVehicleRegisteredException {
        List<Vehicle> allVehicles = vehicleDAO.findAll();
        if(allVehicles == null || allVehicles.isEmpty())
            throw new NoVehicleRegisteredException("No Vehicle is registered");
        return allVehicles;
    }

    @Override
    public List<Vehicle> getVehicleByUserId(int id) throws NoVehicleRegisteredByUser{
        Users users = usersDAO.findById(id);
        List<Booking> bookingsByUserId = bookingDAO.findByUsers(users);
        List<Vehicle> vehiclesByUserId = new ArrayList<>();
        for (Booking b : bookingsByUserId) {
            vehiclesByUserId.add(b.getVehicle());
        }
        if(vehiclesByUserId == null || vehiclesByUserId.isEmpty())
            throw new NoVehicleRegisteredByUser("No vehicle is registered by this user");
        return vehiclesByUserId;
    }

    @Override
    public List<Vehicle> getAvailableVehicles(int locationId) throws NoVehicleAvailableException{
        List<Vehicle> vehiclesByAvailabilityStatus = vehicleDAO.findByAvailabilityStatus(1);
        List<Vehicle> availableVehicles = new ArrayList<>();
        for (Vehicle v: vehiclesByAvailabilityStatus) {
            if((v.getLocation().getId()) == (locationId))
                availableVehicles.add(v);
        }
        if(availableVehicles == null || availableVehicles.isEmpty())
            throw new NoVehicleAvailableException("Sorry ! No vehicle is available");
        return availableVehicles;
    }
}

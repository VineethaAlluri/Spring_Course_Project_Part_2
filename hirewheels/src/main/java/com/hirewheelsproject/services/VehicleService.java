package com.hirewheelsproject.services;

import com.hirewheelsproject.entities.Booking;
import com.hirewheelsproject.entities.Vehicle;
import com.hirewheelsproject.exceptions.NoVehicleAvailableException;
import com.hirewheelsproject.exceptions.NoVehicleRegisteredByUser;
import com.hirewheelsproject.exceptions.NoVehicleRegisteredException;

import java.util.List;

public interface VehicleService {
    public List<Vehicle> getAllVehicles() throws NoVehicleRegisteredException;

    public List<Vehicle> getVehicleByUserId(int id) throws NoVehicleRegisteredByUser;

    public List<Vehicle> getAvailableVehicles(int locationId) throws NoVehicleAvailableException;
}

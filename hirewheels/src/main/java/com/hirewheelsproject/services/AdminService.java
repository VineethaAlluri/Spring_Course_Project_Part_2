package com.hirewheelsproject.services;


import com.hirewheelsproject.entities.Vehicle;
import com.hirewheelsproject.exceptions.NoVehicleRegisteredException;
import com.hirewheelsproject.exceptions.VehicleAlreadyRegisteredException;

public interface AdminService {

    public Vehicle registerVehicle(Vehicle vehicle) throws
            VehicleAlreadyRegisteredException;

    public Vehicle changeAvailability(Vehicle vehicle);
}

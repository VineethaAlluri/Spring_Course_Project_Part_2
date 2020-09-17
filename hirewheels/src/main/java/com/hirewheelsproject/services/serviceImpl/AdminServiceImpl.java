package com.hirewheelsproject.services.serviceImpl;

import com.hirewheelsproject.daos.VehicleDAO;
import com.hirewheelsproject.entities.Vehicle;
import com.hirewheelsproject.exceptions.NoVehicleRegisteredException;
import com.hirewheelsproject.exceptions.VehicleAlreadyRegisteredException;
import com.hirewheelsproject.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("adminServiceImpl")
public class AdminServiceImpl implements AdminService {

    @Autowired @Qualifier("vehicleDAO")
    private VehicleDAO vehicleDAO;

    @Override
    public Vehicle registerVehicle(Vehicle vehicle) throws VehicleAlreadyRegisteredException {
        Vehicle vehicleByVehicleNumber = vehicleDAO.findByVehicleNumber
                (vehicle.getVehicleNumber());
        if(vehicleByVehicleNumber == null) {
            vehicle.setAvailabilityStatus(1);
            vehicleDAO.save(vehicle);
            return vehicle;
        }
        else
        throw new VehicleAlreadyRegisteredException("Vehicle is already registered");
    }

    @Override
    public Vehicle changeAvailability(Vehicle vehicle) {
        if(vehicle.getAvailabilityStatus()==1)
            vehicle.setAvailabilityStatus(0);
        else
            vehicle.setAvailabilityStatus(1);
        vehicleDAO.save(vehicle);
        return vehicle;
    }
}

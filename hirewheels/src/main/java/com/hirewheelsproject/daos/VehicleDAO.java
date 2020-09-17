package com.hirewheelsproject.daos;

import com.hirewheelsproject.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("vehicleDAO")
public interface VehicleDAO extends JpaRepository<Vehicle, Integer> {
    public Vehicle findByVehicleNumber(String vehicleNumber);
    public Vehicle findById(int id);
    public List<Vehicle> findAll();
    public List<Vehicle> findByAvailabilityStatus(int status);
}

package com.hirewheelsproject.daos;

import com.hirewheelsproject.entities.FuelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("fuelTypeDAO")
public interface FuelTypeDAO extends JpaRepository<FuelType, Integer> {
    public FuelType findById(int id);
}

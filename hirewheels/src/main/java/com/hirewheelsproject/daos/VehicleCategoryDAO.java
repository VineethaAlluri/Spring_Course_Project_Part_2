package com.hirewheelsproject.daos;

import com.hirewheelsproject.entities.VehicleCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vehicleCategoryDAO")
public interface VehicleCategoryDAO extends JpaRepository<VehicleCategory, Integer> {
    public VehicleCategory findByName(String name);
}

package com.hirewheelsproject.daos;

import com.hirewheelsproject.entities.VehicleSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vehicleSubCategoryDAO")
public interface VehicleSubCategoryDAO extends JpaRepository<VehicleSubCategory, Integer> {
        public VehicleSubCategory findById(int id);
}

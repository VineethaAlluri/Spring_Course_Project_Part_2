package com.hirewheelsproject.daos;

import com.hirewheelsproject.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("locationDAO")
public interface LocationDAO extends JpaRepository<Location, Integer> {
    public Location findById(int id);
}

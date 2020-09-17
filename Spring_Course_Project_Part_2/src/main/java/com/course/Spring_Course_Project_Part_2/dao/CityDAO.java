package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.City;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository("cityDAO")
public interface CityDAO extends JpaRepository<City,Integer>{
    public City findByName(String name);
}

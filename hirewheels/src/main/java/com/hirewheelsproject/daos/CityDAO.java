package com.hirewheelsproject.daos;



import com.hirewheelsproject.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("cityDAO")
public interface CityDAO extends JpaRepository<City,Integer> {
    public City findByName(String name);
}

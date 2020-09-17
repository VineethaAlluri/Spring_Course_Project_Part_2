package com.testingBeans.dao;

import com.testingBeans.entities.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("carDAO")
public interface CarDAO extends JpaRepository<Car, Integer> {
    public Car findById(int id);
}

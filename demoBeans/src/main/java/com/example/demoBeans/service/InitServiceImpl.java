package com.testingBeans.service;

import com.testingBeans.dao.CarDAO;
import com.testingBeans.entities.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service("initService")
public class InitServiceImpl implements InitService{

    public void init() {
        insertCar();
    }

    public void insertCar() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CarDAO carDAO = (CarDAO) context.getBean("carDAO");
        Car car = new Car("HondaCity");
        carDAO.save(car);
    }
}

package com.hirewheelsproject.controllers;

import com.hirewheelsproject.dtos.BookingDTO;
import com.hirewheelsproject.entities.Booking;
import com.hirewheelsproject.entities.Vehicle;
import com.hirewheelsproject.exceptions.APIException;
import com.hirewheelsproject.exceptions.InsufficientBalanceException;
import com.hirewheelsproject.exceptions.NoVehicleAvailableException;
import com.hirewheelsproject.exceptions.NoVehicleRegisteredException;
import com.hirewheelsproject.services.VehicleService;
import com.hirewheelsproject.validators.VehicleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class VehicleController {

    @Autowired @Qualifier("vehicleValidatorImpl")
    private VehicleValidator vehicleValidator;

    @Autowired @Qualifier("vehicleServiceImpl")
    private VehicleService vehicleService;

    @GetMapping("/vehicles")
    @ResponseBody
    public ResponseEntity addBookings(@RequestParam("categoryName") String categoryName, @RequestParam Date pickUpDate,
                                      @RequestParam Date dropDate, @RequestParam int locationId) throws APIException, NoVehicleAvailableException , NoVehicleRegisteredException {
        ResponseEntity responseEntity = null;
        if(categoryName == null || pickUpDate == null || dropDate == null || locationId == 0)
        {
          responseEntity = new ResponseEntity(vehicleService.getAllVehicles(), HttpStatus.OK);
          return responseEntity;
        }
        vehicleValidator.validateAvailableVehicles(pickUpDate, dropDate);
        List<Vehicle>  availableVehicles = vehicleService.getAvailableVehicles(locationId);
        if(availableVehicles != null){
            responseEntity = new ResponseEntity(availableVehicles, HttpStatus.OK);
        }
        return responseEntity;
    }
}

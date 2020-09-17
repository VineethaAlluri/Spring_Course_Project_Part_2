package com.hirewheelsproject.controllers;

import com.hirewheelsproject.daos.VehicleDAO;
import com.hirewheelsproject.dtos.AddVehicleDTO;
import com.hirewheelsproject.dtos.UserSignUpDTO;
import com.hirewheelsproject.entities.Users;
import com.hirewheelsproject.entities.Vehicle;
import com.hirewheelsproject.exceptions.APIException;
import com.hirewheelsproject.exceptions.UserAlreadyExistsException;
import com.hirewheelsproject.exceptions.VehicleAlreadyRegisteredException;
import com.hirewheelsproject.responses.CustomResponse;
import com.hirewheelsproject.services.AdminService;
import com.hirewheelsproject.utils.DTOEntityConverter;
import com.hirewheelsproject.validators.AddVehicleValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class AdminController {

    @Autowired @Qualifier("addVehicleValidatorImpl")
    private AddVehicleValidator addVehicleValidator;

    @Autowired @Qualifier("DTOEntityConverter")
    private DTOEntityConverter dtoEntityConverter;

    @Autowired @Qualifier("adminServiceImpl")
    private AdminService adminService;

    @Autowired @Qualifier("vehicleDAO")
    private VehicleDAO vehicleDAO;

    @RequestMapping(method = RequestMethod.POST, value = "/vehicles")
    @ResponseBody
    public ResponseEntity addVehicle(@RequestBody AddVehicleDTO addVehicleDTO) throws APIException, VehicleAlreadyRegisteredException {
        ResponseEntity responseEntity = null;
        addVehicleValidator.validateAddVehicle(addVehicleDTO);
        Vehicle vehicle = dtoEntityConverter.addVehicleDTOtoVehicleConverter(addVehicleDTO);
        Vehicle addedVehicle = null;
        addedVehicle = adminService.registerVehicle(vehicle);
        if(addedVehicle != null){
            CustomResponse response = new CustomResponse(new Date(),
                    "Vehicle Added Successfully", HttpStatus.CREATED.value());
            responseEntity = new ResponseEntity(response, HttpStatus.CREATED);
        }
        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/vehicles/{vehicleid}")
    @ResponseBody
    public ResponseEntity changeAvailabilityStatus(@PathVariable("vehicleid") int id) {
        ResponseEntity responseEntity = null;
        Vehicle vehicle = vehicleDAO.findById(id);
        if(vehicle == null ) {
            CustomResponse response = new CustomResponse(new Date(),
                    "No Vehicle with Given Id", HttpStatus.BAD_REQUEST.value());
            responseEntity = new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
        vehicle = adminService.changeAvailability(vehicle);
        if(vehicle != null){
            CustomResponse response = new CustomResponse(new Date(),
                    "Activity Performed Successfully", HttpStatus.OK.value());
            responseEntity = new ResponseEntity(response, HttpStatus.OK);
        }
        return responseEntity;
    }
}

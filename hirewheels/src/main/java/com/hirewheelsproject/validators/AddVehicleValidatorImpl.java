package com.hirewheelsproject.validators;

import com.hirewheelsproject.daos.LocationDAO;
import com.hirewheelsproject.dtos.AddVehicleDTO;
import com.hirewheelsproject.exceptions.APIException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("addVehicleValidatorImpl")
public class AddVehicleValidatorImpl implements AddVehicleValidator{

    @Autowired @Qualifier("locationDAO")
    private LocationDAO locationDAO;

    @Override
    public void validateAddVehicle(AddVehicleDTO addVehicleDTO) throws APIException {
        if(addVehicleDTO.getAvailabilityStatus() == 0)
            throw new APIException("Fields shouldn’t be null or empty");
        if(addVehicleDTO.getColor() == null || addVehicleDTO.getColor().isEmpty())
            throw new APIException("Fields shouldn’t be null or empty");
        if(addVehicleDTO.getFuelTypeId() == 0)
            throw new APIException("Fields shouldn’t be null or empty");
        if(addVehicleDTO.getLocationId() == 0)
            throw new APIException("Fields shouldn’t be null or empty");
        if(addVehicleDTO.getVehicleImageUrl() == null || addVehicleDTO.getVehicleImageUrl().isEmpty())
            throw new APIException("Fields shouldn’t be null or empty");
        if(addVehicleDTO.getVehicleModel()==null || addVehicleDTO.getVehicleModel().isEmpty())
            throw new APIException("Fields shouldn’t be null or empty");
        if(addVehicleDTO.getVehicleNumber()==null || addVehicleDTO.getVehicleNumber().isEmpty())
            throw new APIException("Fields shouldn’t be null or empty");
        if(addVehicleDTO.getVehicleSubCategoryId() == 0)
            throw new APIException("Fields shouldn’t be null or empty");
        if(locationDAO.findById(addVehicleDTO.getLocationId()) == null)
            throw new APIException("Invalid Location Id for vehicle");
    }
}

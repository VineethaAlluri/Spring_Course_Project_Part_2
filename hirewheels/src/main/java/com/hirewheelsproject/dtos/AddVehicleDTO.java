package com.hirewheelsproject.dtos;

import com.hirewheelsproject.entities.FuelType;
import com.hirewheelsproject.entities.Location;
import com.hirewheelsproject.entities.VehicleSubCategory;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class AddVehicleDTO {

    private String vehicleModel;

    private String vehicleNumber;

    private int vehicleSubCategoryId;

    private String color;

    private int locationId;

    private int fuelTypeId;

    private int availabilityStatus;

    private String vehicleImageUrl;
}

package com.hirewheelsproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Vehicle {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name ="vehicle_model", nullable = false)
    private String vehicleModel;

    @Column(name="vehicle_number", nullable = false, unique = true)
    private String vehicleNumber;

    @ManyToOne
    private VehicleSubCategory vehicleSubCategory;

    @Column(nullable = false)
    private String color;

    @ManyToOne
    private Location location;

    @ManyToOne
    private FuelType fuelType;

    @Column(name="availability_status", nullable = false)
    private int availabilityStatus;

    @Column(name = "vehicle_image_url", nullable = false)
    private String vehicleImageUrl;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    List<Booking> bookings;

    public Vehicle(String vehicleModel, String vehicleNumber, VehicleSubCategory vehicleSubCategory,
                   String color, Location location, FuelType fuelType, int availabilityStatus,
                   String vehicleImageUrl) {
        this.vehicleModel=vehicleModel;
        this.vehicleNumber=vehicleNumber;
        this.vehicleSubCategory=vehicleSubCategory;
        this.color=color;
        this.location=location;
        this.fuelType=fuelType;
        this.availabilityStatus=availabilityStatus;
        this.vehicleImageUrl=vehicleImageUrl;
    }

    public Vehicle( ) {
    }

}

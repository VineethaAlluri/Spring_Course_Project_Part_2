package com.upgrad.hirewheels.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class VehicleSubCategory {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="vehicle_subcategory_name", nullable = false, unique = true)
    private String name;

    @Column(name="price_per_day",precision = 8,scale = 2, nullable = false)
    private Double pricePerDay;

    @ManyToOne
    private VehicleCategory vehicleCategory;

    @OneToMany(mappedBy = "vehicleSubCategory")
    List<Vehicle> vehicles;

    public VehicleSubCategory(String name, Double pricePerDay, VehicleCategory vehicleCategory) {
        this.name=name;
        this.pricePerDay=pricePerDay;
        this.vehicleCategory=vehicleCategory;
    }

    public VehicleSubCategory() {

    }

    @Override
    public String toString() {
        return "VehicleSubCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pricePerDay=" + pricePerDay +
                ", vehicleCategory=" + vehicleCategory +
                ", vehicles=" + vehicles +
                '}';
    }
}

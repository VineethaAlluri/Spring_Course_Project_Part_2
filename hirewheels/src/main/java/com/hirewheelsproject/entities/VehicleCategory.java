package com.hirewheelsproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class VehicleCategory {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="vehicle_category_name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "vehicleCategory")
    List<VehicleSubCategory> vehicleSubCategories;

    public VehicleCategory() {

    }

    public VehicleCategory(String name) {
        this.name = name;
    }

}

package com.hirewheelsproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class FuelType {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="fuel_type",nullable = false,unique = true)
    private String type;

    @OneToMany(mappedBy = "fuelType")
    List<Vehicle> vehicles;

    public FuelType(String type) {
        this.type = type;
    }

    public FuelType() {

    }

    @Override
    public String toString() {
        return "FuelType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}

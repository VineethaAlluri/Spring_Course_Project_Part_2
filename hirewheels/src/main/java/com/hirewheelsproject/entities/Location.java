package com.hirewheelsproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Location {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="location_name", nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String pincode;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "location")
    List<Vehicle> vehicles;

    @OneToMany(mappedBy = "location")
    List<Booking> bookings;

    public Location(String name, String address, String pincode, City city) {
        this.name = name;
        this.address = address;
        this.pincode = pincode;
        this.city = city;
    }

    public Location() {

    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", pincode='" + pincode + '\'' +
                ", city=" + city +
                ", vehicles=" + vehicles +
                ", bookings=" + bookings +
                '}';
    }
}

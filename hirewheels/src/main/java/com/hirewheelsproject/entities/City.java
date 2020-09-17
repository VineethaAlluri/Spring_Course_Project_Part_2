package com.hirewheelsproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class City {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="city_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "city")
    List<Location> locations;

    public City(String name) {
        this.name = name;
    }

    public City() {

    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", locations=" + locations +
                '}';
    }
}

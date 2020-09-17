package com.upgrad.hirewheels.entities;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Getter
@Setter
@Entity
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name ="role_name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    @JsonManagedReference
    List<Users> users;

    public Role(String name) {
        this.name = name;
    }

    public Role() {

    }

}

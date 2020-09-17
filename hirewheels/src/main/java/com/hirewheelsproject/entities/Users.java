package com.hirewheelsproject.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Users {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name ="first_name", nullable = false)
    private String firstName;

    @Column(name ="last_name")
    private String lastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name="mobile_no", nullable = false, unique = true)
    private String mobileNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Role role;

    @Column(name="wallet_money", precision = 8, scale = 2)
    private Double walletMoney = 10000.00;

    @OneToMany(mappedBy = "users")
    List<Booking> bookings;

    public Users(String firstName,String lastName,String password,String email,
                 String mobileNumber, Role role, double walletMoney) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.role= role;
        this.walletMoney = walletMoney;
    }
    public Users() {
    }

}

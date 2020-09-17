package com.hirewheelsproject.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@Entity
public class Booking {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name ="booking_date", nullable = false)
    private Date bookingDate;

    @Column(name="pickup_date", nullable = false)
    private Date pickUpDate;

    @Column(name="dropoff_date", nullable = false)
    private Date dropOffDate;

    @ManyToOne
    private Location location;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Users users;

    @Column(precision = 8, scale = 2, nullable = false)
    private Double amount;

    public Booking(Date bookingDate, Date pickUpDate, Date dropOffDate, Location location,
                   Vehicle vehicle, Users users, Double amount){
        this.bookingDate=bookingDate;
        this.pickUpDate=pickUpDate;
        this.dropOffDate=dropOffDate;
        this.location=location;
        this.vehicle=vehicle;
        this.users=users;
        this.amount=amount;
    }

    public Booking() {

    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", bookingDate=" + bookingDate +
                ", pickUpDate=" + pickUpDate +
                ", dropOffDate=" + dropOffDate +
                ", location=" + location +
                ", vehicle=" + vehicle +
                ", users=" + users +
                ", amount=" + amount +
                '}';
    }
}

package com.hirewheelsproject.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hirewheelsproject.entities.Location;
import com.hirewheelsproject.entities.Users;
import com.hirewheelsproject.entities.Vehicle;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
public class BookingDTO {

    private int id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date bookingDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date pickUpDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dropOffDate;
    private int locationId;

    private int  vehicleId;

    private int usersId;

    private Double amount;
}

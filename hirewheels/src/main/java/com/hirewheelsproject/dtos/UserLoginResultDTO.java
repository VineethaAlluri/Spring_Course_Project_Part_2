package com.hirewheelsproject.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginResultDTO {

    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String mobileNumber;

    private Double walletMoney;

    private String roleName;
}

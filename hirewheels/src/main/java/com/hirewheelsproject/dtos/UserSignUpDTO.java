package com.hirewheelsproject.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSignUpDTO {

    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private String mobileNumber;


}

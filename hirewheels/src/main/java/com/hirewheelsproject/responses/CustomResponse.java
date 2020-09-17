package com.hirewheelsproject.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CustomResponse {
    private String errorMessage;
    private int statusCode;
    private Date date;

    public CustomResponse(){
    }

    public CustomResponse(Date date,String errorMessage, int statusCode) {
        this.date=date;
        this.errorMessage = errorMessage;
        this.statusCode = statusCode;
    }
}

package com.hirewheelsproject.validators;

import com.hirewheelsproject.dtos.UserSignUpDTO;
import com.hirewheelsproject.exceptions.APIException;

public interface UserSignUpDTOValidator {
    public void validateUserSignUp(UserSignUpDTO userSignUpDTO) throws APIException;
}

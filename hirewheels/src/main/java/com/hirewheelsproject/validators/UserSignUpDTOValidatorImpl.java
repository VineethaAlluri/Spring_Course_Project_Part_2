package com.hirewheelsproject.validators;

import com.hirewheelsproject.dtos.UserSignUpDTO;
import com.hirewheelsproject.exceptions.APIException;
import org.springframework.stereotype.Service;

@Service("userSignUpDTOValidatorImpl")
public class UserSignUpDTOValidatorImpl implements UserSignUpDTOValidator{

    @Override
    public void validateUserSignUp(UserSignUpDTO userSignUpDTO) throws APIException {
        if(userSignUpDTO.getFirstName() == null || userSignUpDTO.getFirstName().isEmpty())
            throw new APIException("FirstName cannot be null or empty");
        if(userSignUpDTO.getPassword() == null || userSignUpDTO.getPassword().isEmpty() ||
                userSignUpDTO.getPassword().length() < 5)
            throw new APIException("Password cannot be null or less than 5 characters");
        if(userSignUpDTO.getMobileNumber() == null || userSignUpDTO.getMobileNumber().length()!=10)
            throw  new APIException("Mobile Number cannot be null or empty and must be 10 digits");
    }
}

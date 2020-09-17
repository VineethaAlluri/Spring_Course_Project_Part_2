package com.hirewheelsproject.controllers;


import com.hirewheelsproject.dtos.UserLoginDTO;
import com.hirewheelsproject.dtos.UserLoginResultDTO;
import com.hirewheelsproject.dtos.UserSignUpDTO;
import com.hirewheelsproject.entities.Users;
import com.hirewheelsproject.exceptions.APIException;
import com.hirewheelsproject.exceptions.UnauthorizedUserException;
import com.hirewheelsproject.exceptions.UserAlreadyExistsException;
import com.hirewheelsproject.exceptions.UserIsNotRegisteredException;
import com.hirewheelsproject.responses.CustomResponse;
import com.hirewheelsproject.services.UserService;
import com.hirewheelsproject.utils.DTOEntityConverter;
import com.hirewheelsproject.utils.EntityDTOConverter;
import com.hirewheelsproject.validators.UserSignUpDTOValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class AuthController {

    @Autowired @Qualifier("userSignUpDTOValidatorImpl")
    private UserSignUpDTOValidator userSignUpDTOValidator;

    @Autowired @Qualifier("DTOEntityConverter")
    private DTOEntityConverter dtoEntityConverter;

    @Autowired @Qualifier("userServiceImpl")
    private UserService userService;

    @Autowired @Qualifier("entityDTOConverter")
    private EntityDTOConverter entityDTOConverter;

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    @ResponseBody
    public ResponseEntity userSignUp(@RequestBody UserSignUpDTO userSignUpDTO) throws APIException, UserAlreadyExistsException{
        ResponseEntity responseEntity = null;
        userSignUpDTOValidator.validateUserSignUp(userSignUpDTO);
        Users users = dtoEntityConverter.userSignUpDTOtoUsersConverter(userSignUpDTO);
        Users savedUsers = null;
        savedUsers = userService.createUsers(users);
        if(savedUsers != null){
            CustomResponse response = new CustomResponse(new Date(),
                    "User Successfully Signed Up",HttpStatus.CREATED.value());
            responseEntity = new ResponseEntity(response, HttpStatus.CREATED);
        }
       return responseEntity;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/access_token/")
    @ResponseBody
    public ResponseEntity userLogin(@RequestBody UserLoginDTO userLoginDTO) throws UnauthorizedUserException, UserIsNotRegisteredException {
        ResponseEntity responseEntity = null;
        Users users = dtoEntityConverter.userLoginDTOtoUsersConvertor(userLoginDTO);
        Users savedUsers = null;
        savedUsers = userService.getUser(users.getEmail(), users.getPassword());
        if(savedUsers != null){
           UserLoginResultDTO userLoginResultDTO = entityDTOConverter.usersToUserLoginResultDTOConverter(savedUsers);
            responseEntity = new ResponseEntity(userLoginResultDTO, HttpStatus.ACCEPTED);
        }
        return responseEntity;
    }
}

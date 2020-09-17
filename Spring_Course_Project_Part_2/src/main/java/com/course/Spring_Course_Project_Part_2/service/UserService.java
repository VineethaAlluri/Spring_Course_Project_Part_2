package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.exceptions.UnauthorizedUserException;
import com.upgrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.hirewheels.exceptions.UserIsNotRegisteredException;

public interface UserService {
    public Users createUsers(Users users) throws UserAlreadyExistsException;

    public Users getUser(String email, String password) throws UserIsNotRegisteredException,
            UnauthorizedUserException;
}

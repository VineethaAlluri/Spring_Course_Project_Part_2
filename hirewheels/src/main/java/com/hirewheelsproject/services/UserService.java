package com.hirewheelsproject.services;


import com.hirewheelsproject.entities.Users;
import com.hirewheelsproject.exceptions.UnauthorizedUserException;
import com.hirewheelsproject.exceptions.UserAlreadyExistsException;
import com.hirewheelsproject.exceptions.UserIsNotRegisteredException;

public interface UserService {
    public Users createUsers(Users users) throws UserAlreadyExistsException;

    public Users getUser(String email, String password) throws UserIsNotRegisteredException,
            UnauthorizedUserException;
}

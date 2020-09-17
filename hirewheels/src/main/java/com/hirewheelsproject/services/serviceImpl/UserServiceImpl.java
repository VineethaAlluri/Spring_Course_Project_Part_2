package com.hirewheelsproject.services.serviceImpl;

import com.hirewheelsproject.daos.UsersDAO;
import com.hirewheelsproject.entities.Users;
import com.hirewheelsproject.exceptions.UnauthorizedUserException;
import com.hirewheelsproject.exceptions.UserAlreadyExistsException;
import com.hirewheelsproject.exceptions.UserIsNotRegisteredException;
import com.hirewheelsproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired @Qualifier("usersDAO")
    private UsersDAO usersDAO;

    public Users createUsers(Users users) throws UserAlreadyExistsException {
        Boolean uniqueEmail = false;
        Boolean uniqueMobile = false;
        System.out.println(users.getRole());
        Users userByEmail = usersDAO.findByEmail(users.getEmail());
        if(userByEmail == null )
            uniqueEmail = true;
        else
            throw new UserAlreadyExistsException("Email Already Exists");
        Users userByMobileNumber = usersDAO.findByMobileNumber(
                users.getMobileNumber());
        if(userByMobileNumber == null)
            uniqueMobile = true;
        else
            throw new UserAlreadyExistsException("Mobile Number Already Exists");
        if(uniqueEmail && uniqueMobile)
            usersDAO.save(users);
        return users;
    }


    public Users getUser(String email, String password) throws UserIsNotRegisteredException, UnauthorizedUserException {
        Users userByEmail = usersDAO.findByEmail(email);
        if(userByEmail == null)
            throw new UserIsNotRegisteredException("User Not Registered");
        if(userByEmail.getPassword().equals(password))
            return userByEmail;
        else
            throw new UnauthorizedUserException("User Unauthorized");
    }


}

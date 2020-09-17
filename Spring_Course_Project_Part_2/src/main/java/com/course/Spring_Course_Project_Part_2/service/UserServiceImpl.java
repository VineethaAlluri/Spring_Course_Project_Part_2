package com.upgrad.hirewheels.services;

import com.upgrad.hirewheels.dao.UsersDAO;
import com.upgrad.hirewheels.entities.Booking;
import com.upgrad.hirewheels.entities.City;
import com.upgrad.hirewheels.entities.Users;
import com.upgrad.hirewheels.exceptions.UnauthorizedUserException;
import com.upgrad.hirewheels.exceptions.UserAlreadyExistsException;
import com.upgrad.hirewheels.exceptions.UserIsNotRegisteredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{



    public Users createUsers(Users users) throws UserAlreadyExistsException{
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UsersDAO usersDAO = (UsersDAO) context.getBean("usersDAO");
        Boolean uniqueEmail = false;
        Boolean uniqueMobile = false;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UsersDAO usersDAO = (UsersDAO) context.getBean("usersDAO");
        Users userByEmail = usersDAO.findByEmail(email);
        if(userByEmail == null)
            throw new UserIsNotRegisteredException("User Not Registered");
        if(userByEmail.getPassword().equals(password))
            return userByEmail;
        else
            throw new UnauthorizedUserException("User Unauthorized");
    }


}

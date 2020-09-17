package com.upgrad.hirewheels.dao;

import com.upgrad.hirewheels.entities.Role;
import com.upgrad.hirewheels.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("usersDAO")
public interface UsersDAO extends JpaRepository<Users, Integer> {
    public Users findByRole(Role role);
    public Users findByEmail(String email);
    public Users findByMobileNumber(String mobileNumber);
    public Users findById(int id);
}

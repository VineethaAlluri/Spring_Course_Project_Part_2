package com.hirewheelsproject.daos;


import com.hirewheelsproject.entities.Role;
import com.hirewheelsproject.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("usersDAO")
public interface UsersDAO extends JpaRepository<Users, Integer> {
    public Users findByRole(Role role);
    public Users findByEmail(String email);
    public Users findByMobileNumber(String mobileNumber);
    public Users findById(int id);
}

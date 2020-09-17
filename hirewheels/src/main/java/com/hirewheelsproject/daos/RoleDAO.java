package com.hirewheelsproject.daos;


import com.hirewheelsproject.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("roleDAO")
public interface RoleDAO extends JpaRepository<Role, Integer> {
    public Role findByName(String name);
}

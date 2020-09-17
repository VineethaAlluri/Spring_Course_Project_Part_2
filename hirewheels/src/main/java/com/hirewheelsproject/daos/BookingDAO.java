package com.hirewheelsproject.daos;

import com.hirewheelsproject.entities.Booking;
import com.hirewheelsproject.entities.Users;
import com.hirewheelsproject.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bookingDAO")
public interface BookingDAO extends JpaRepository<Booking,Integer> {
    public List<Booking> findByUsers(Users users);
    public Booking findById(int id);
}

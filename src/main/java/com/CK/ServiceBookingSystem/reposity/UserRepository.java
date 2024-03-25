package com.CK.ServiceBookingSystem.reposity;

import com.CK.ServiceBookingSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//A way to connect Database , such as JDBC , JPA
//We use JPA this time

public interface UserRepository extends JpaRepository<User, Long> {
}

package com.CK.ServiceBookingSystem.reposity;

import com.CK.ServiceBookingSystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//A way to connect Database , such as JDBC , JPA
//We use JPA this time

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByEmail(String email);

}

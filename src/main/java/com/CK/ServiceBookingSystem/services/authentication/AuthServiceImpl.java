package com.CK.ServiceBookingSystem.services.authentication;

import com.CK.ServiceBookingSystem.dto.SignupRequestDTO;
import com.CK.ServiceBookingSystem.dto.UserDto;
import com.CK.ServiceBookingSystem.entity.User;
import com.CK.ServiceBookingSystem.enums.UserRole;
import com.CK.ServiceBookingSystem.reposity.UserRepository;
import com.CK.ServiceBookingSystem.services.authentication.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Add this annotation to mark the class as a Spring service bean
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    public UserDto signupClient(SignupRequestDTO signupRequestDTO) {
        // Create a new user entity and set its properties
        User user = new User();

        user.setName(signupRequestDTO.getName());
        user.setLastname(signupRequestDTO.getLastname());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPhone(signupRequestDTO.getPhone());
        user.setPassword(signupRequestDTO.getPassword());

        // Save the user entity and convert it to a DTO
        user.setRole(UserRole.CLIENT);
        return userRepository.save(user).getDto();
    }

    // Checks if a user with a given email already exists in the system
    public Boolean presentByEmail(String email) {
        return userRepository.findFirstByEmail(email) != null;
    }

    public UserDto signupCompany(SignupRequestDTO signupRequestDTO) {
        // Create a new user entity and set its properties
        User user = new User();

        user.setName(signupRequestDTO.getName());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPhone(signupRequestDTO.getPhone());
        user.setPassword(signupRequestDTO.getPassword());

        // Save the user entity and convert it to a DTO
        user.setRole(UserRole.COMPANY);
        return userRepository.save(user).getDto();
    }
}

package com.CK.ServiceBookingSystem.services.authentication;

import com.CK.ServiceBookingSystem.dto.SignupRequestDTO;
import com.CK.ServiceBookingSystem.dto.UserDto;
import com.CK.ServiceBookingSystem.entity.User;
import com.CK.ServiceBookingSystem.enums.UserRole;
import com.CK.ServiceBookingSystem.reposity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Add this annotation to mark the class as a Spring service bean
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    public UserDto signupClient(SignupRequestDTO signupRequestDTO) {
        User user = new User();

        user.setName(signupRequestDTO.getName());
        user.setLastname(signupRequestDTO.getLastname());
        user.setEmail(signupRequestDTO.getEmail());
        user.setPhone(signupRequestDTO.getPhone());
        user.setPassword(signupRequestDTO.getPassword());

        user.setRole(UserRole.CLIENT);

        return userRepository.save(user).getDto();
    }
}

package com.CK.ServiceBookingSystem.services.authentication;

import com.CK.ServiceBookingSystem.dto.SignupRequestDTO;
import com.CK.ServiceBookingSystem.dto.UserDto;

public interface AuthService {

    UserDto signupClient(SignupRequestDTO signupRequestDTO);
}

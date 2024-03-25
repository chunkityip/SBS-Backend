package com.CK.ServiceBookingSystem.controller;

import com.CK.ServiceBookingSystem.dto.SignupRequestDTO;
import com.CK.ServiceBookingSystem.dto.UserDto;
import com.CK.ServiceBookingSystem.services.authentication.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @PostMapping("/client/sign-up")
    public ResponseEntity<?> signupClient(@RequestBody SignupRequestDTO signupRequestDTO) {
        // Check if the client user is already registered
        if (authService.presentByEmail(signupRequestDTO.getEmail())) {
            return new ResponseEntity<>("You already register in our system." , HttpStatus.NOT_ACCEPTABLE);
        }

        // Sign up the client and return the created user DTO
        UserDto createdUser = authService.signupClient(signupRequestDTO);
        return new ResponseEntity<>(createdUser , HttpStatus.OK);
    }

    @PostMapping("/company/sign-up")
    public ResponseEntity<?> signupCompany(@RequestBody SignupRequestDTO signupRequestDTO) {
        // Check if the company user is already registered
        if (authService.presentByEmail(signupRequestDTO.getEmail())) {
            return new ResponseEntity<>("You already in our system." , HttpStatus.NOT_ACCEPTABLE);
        }

        // Sign up the client and return the created user DTO
        UserDto createdUser = authService.signupClient(signupRequestDTO);
        return new ResponseEntity<>(createdUser , HttpStatus.OK);
    }

}

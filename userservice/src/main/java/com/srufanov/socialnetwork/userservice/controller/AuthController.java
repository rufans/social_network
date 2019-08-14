package com.srufanov.socialnetwork.userservice.controller;

import com.srufanov.socialnetwork.userservice.dto.ApiResponse;
import com.srufanov.socialnetwork.userservice.dto.JwtAuthenticationResponse;
import com.srufanov.socialnetwork.userservice.dto.LoginRequest;
import com.srufanov.socialnetwork.userservice.dto.SignUpRequest;
import com.srufanov.socialnetwork.userservice.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signin")
    public JwtAuthenticationResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return new JwtAuthenticationResponse(authService.authenticateUser(loginRequest));
    }

    @PostMapping("/signup")
    public ApiResponse registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        authService.registerUser(signUpRequest);
        return new ApiResponse(true, "User registered successfully");
    }

}

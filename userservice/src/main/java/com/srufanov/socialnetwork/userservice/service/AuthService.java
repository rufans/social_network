package com.srufanov.socialnetwork.userservice.service;

import com.srufanov.socialnetwork.userservice.dto.LoginRequest;
import com.srufanov.socialnetwork.userservice.dto.SignUpRequest;
import com.srufanov.socialnetwork.userservice.entity.User;
import com.srufanov.socialnetwork.userservice.enumeration.Role;
import com.srufanov.socialnetwork.userservice.exception.UserServiceException;
import com.srufanov.socialnetwork.userservice.repository.UserRepository;
import com.srufanov.socialnetwork.userservice.security.JwtTokenProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider, UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String authenticateUser(LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return tokenProvider.generateToken(authentication);
    }

    @Transactional
    public void registerUser(SignUpRequest signUpRequest) {
        String username = signUpRequest.getUsername();
        String email = signUpRequest.getEmail();

        if (userRepository.existsByUsername(username)) {
            throw new UserServiceException("User with such username already exists");
        }

        if (userRepository.existsByEmail(email)) {
            throw new UserServiceException("Email address is already in use");
        }

        User user = new User(signUpRequest.getName(), username, email, signUpRequest.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton(Role.ROLE_USER));

        userRepository.save(user);
    }

}

package com.car.CarLease.service;

import com.car.CarLease.dto.LoginRequestDTO;
import com.car.CarLease.dto.RegisterRequestDTO;
import com.car.CarLease.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
     UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    public Users register(RegisterRequestDTO registerRequest) {
        Users user = new Users();
        user.setName(registerRequest.getName());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        user.setRole(registerRequest.getRole());
        return userService.registerUser(user);
    }

    public Users login(LoginRequestDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Object principal = authentication.getPrincipal();
        if (principal instanceof Users) {
            return (Users) principal;
        }
        throw new RuntimeException("Invalid user type");
    }

    public void logout() {
        SecurityContextHolder.clearContext();
    }
}
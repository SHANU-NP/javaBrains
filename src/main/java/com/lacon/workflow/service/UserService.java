package com.lacon.workflow.service;

import com.lacon.workflow.constants.Constants;
import com.lacon.workflow.entity.User;
import com.lacon.workflow.model.request.LoginRequest;
import com.lacon.workflow.model.request.RegistrationRequest;
import com.lacon.workflow.model.response.LoginResponse;
import com.lacon.workflow.model.response.SuccessResponse;
import com.lacon.workflow.model.response.UserResponse;
import com.lacon.workflow.repository.UserRepository;
import com.lacon.workflow.service.jwt.JWTService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService  {

    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, JWTService jwtService, AuthenticationManager authenticationManager, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public SuccessResponse registerUser(RegistrationRequest request) {

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhone(request.getPhone());
        user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole());
        user.setUserId(UUID.randomUUID());
        userRepository.save(user);
        return new SuccessResponse(Constants.REGISTRATION_SUCCESS);

    }

    //get all users by role
    public List<User> getUsersByRole(String role) {
        return userRepository.findAllByRole(role);
    }


    public LoginResponse loginUser(LoginRequest loginRequest) {
        User user = userRepository.findByPhone(loginRequest.getUsername())
                .orElseThrow(() -> new BadCredentialsException("Invalid credentials"));

        try {
            // Match the raw password with the encoded password
            if (bCryptPasswordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                Authentication authenticate = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

                if (authenticate.isAuthenticated()) {
                    String token = jwtService.generateToken(user);
                    return new LoginResponse(user, token);
                } else {
                    throw new BadCredentialsException("NOT AUTHENTICATED !!!");
                }
            } else {
                throw new BadCredentialsException("Invalid credentials");
            }
        } catch (Exception e) {
            throw new RuntimeException("Login failed", e);
        }

    }

    public List<UserResponse> getAllUsers(){
        return userRepository.findAll().stream().map(UserResponse::new).collect(Collectors.toList());
    }
}

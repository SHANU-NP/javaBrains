package com.lacon.workflow.service;

import com.lacon.workflow.constants.Constants;
import com.lacon.workflow.entity.User;
import com.lacon.workflow.model.request.RegistrationRequest;
import com.lacon.workflow.model.response.SuccessResponse;
import com.lacon.workflow.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public SuccessResponse registerUser(RegistrationRequest request) {

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhone(request.getPhone());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        user.setCustomerId(UUID.randomUUID());
        userRepository.save(user);
        return new SuccessResponse(Constants.REGISTRATION_SUCCESS);

    }
}

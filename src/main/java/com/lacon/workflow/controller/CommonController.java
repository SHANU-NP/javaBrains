package com.lacon.workflow.controller;


import com.lacon.workflow.model.request.LoginRequest;
import com.lacon.workflow.model.request.RegistrationRequest;
import com.lacon.workflow.model.response.LoginResponse;
import com.lacon.workflow.model.response.RoleResponse;
import com.lacon.workflow.model.response.SuccessResponse;
import com.lacon.workflow.model.response.UserResponse;
import com.lacon.workflow.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.lacon.workflow.constants.Constants.*;

@RestController
@RequestMapping("/v1")
public class CommonController {

    private final UserService userService;

    public CommonController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/user/register")
    public SuccessResponse registerUser(@RequestBody RegistrationRequest request){
        return userService.registerUser(request);
    }

    @GetMapping("/user/role")
    public RoleResponse getRoles(){
        return new RoleResponse(List.of(ROLE_CUSTOMER,ROLE_DOCUMENT_VERIFIER,ROLE_SUPER_VISOR));
    }

    @PostMapping("/user/login")
    public LoginResponse loginUser(@RequestBody LoginRequest loginRequest){
        return userService.loginUser(loginRequest);
    }

    @GetMapping("/users")
    public List<UserResponse> getAllUsers(){
        return userService.getAllUsers();
    }












}

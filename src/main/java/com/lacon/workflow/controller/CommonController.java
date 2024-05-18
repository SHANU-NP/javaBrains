package com.lacon.workflow.controller;


import com.lacon.workflow.model.request.RegistrationRequest;
import com.lacon.workflow.model.response.SuccessResponse;
import com.lacon.workflow.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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










}

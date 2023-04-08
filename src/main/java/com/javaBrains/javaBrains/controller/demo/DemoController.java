package com.javaBrains.javaBrains.controller.demo;


import com.javaBrains.javaBrains.model.request.CreateUserRequest;
import com.javaBrains.javaBrains.model.response.SuccessResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class DemoController implements IDemoController {


    @Override
    public SuccessResponse createUser(CreateUserRequest request) {
        return new SuccessResponse("Success");
    }
}

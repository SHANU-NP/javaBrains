package com.javaBrains.javaBrains.controller.demo;

import com.javaBrains.javaBrains.model.request.CreateUserRequest;
import com.javaBrains.javaBrains.model.response.SuccessResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface IDemoController {


    @ApiOperation(value = "Create new user",notes = "New user can be created using this API",response = SuccessResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "User Successfully created",response = SuccessResponse.class),
            @ApiResponse(code = 400,message = "Invalid request",response =SuccessResponse.class)
    })
    @PostMapping(value = "/create/user")
    public SuccessResponse createUser(@Valid @RequestBody CreateUserRequest request);




}

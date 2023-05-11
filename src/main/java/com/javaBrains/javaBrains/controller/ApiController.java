package com.javaBrains.javaBrains.controller;

import com.javaBrains.javaBrains.model.PolicyRequest;
import com.javaBrains.javaBrains.model.SuccessResponse;
import com.javaBrains.javaBrains.service.PolicyService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    private final PolicyService policyService;

    public ApiController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping("/create/policy")
    public SuccessResponse createPolicy(@RequestBody PolicyRequest request){
        return policyService.createNewPolicy(request);
    }
}

package com.javaBrains.javaBrains.controller;

import com.javaBrains.javaBrains.model.PolicyRequest;
import com.javaBrains.javaBrains.model.SuccessResponse;
import com.javaBrains.javaBrains.service.PolicyService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/status")
    public String status(@RequestParam(value = "ping", defaultValue = "true")String value){
        return "API is running...";
    }
}

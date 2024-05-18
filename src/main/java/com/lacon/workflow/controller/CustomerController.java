package com.lacon.workflow.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lacon.workflow.model.request.DocumentVerificationRequest;
import com.lacon.workflow.model.response.SuccessResponse;
import com.lacon.workflow.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/initiate/work-flow")
    public SuccessResponse documentVerificationRequestInitiate(@RequestBody DocumentVerificationRequest documentVerificationRequest) throws JsonProcessingException {
        return customerService.documentVerificationRequestInitiate(documentVerificationRequest);
    }



}

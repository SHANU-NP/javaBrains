package com.lacon.workflow.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lacon.workflow.model.request.DocumentVerificationRequest;
import com.lacon.workflow.model.response.CustomerDocumentDetailsResponse;
import com.lacon.workflow.model.response.SuccessResponse;
import com.lacon.workflow.service.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping("/customer/initiate/work-flow")
    public SuccessResponse documentVerificationRequestInitiate(@RequestBody DocumentVerificationRequest documentVerificationRequest) throws JsonProcessingException {
        return customerService.documentVerificationRequestInitiate(documentVerificationRequest);
    }

    @GetMapping("/customer/{customerId}/document-status")
    public CustomerDocumentDetailsResponse getCustomerDocumentDetails(@PathVariable(value = "customerId") String customerId) throws JsonProcessingException {
        return customerService.getCustomerDocumentDetails(customerId);
    }



}

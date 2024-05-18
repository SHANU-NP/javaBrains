package com.lacon.workflow.controller;


import com.lacon.workflow.model.response.JobResponse;
import com.lacon.workflow.service.backoffice.BackofficeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class BackofficeController {
    private final BackofficeService backofficeService;

    public BackofficeController(BackofficeService backofficeService) {
        this.backofficeService = backofficeService;
    }

    @GetMapping("/backoffice/job/{userId}/{operation}")
    public List<JobResponse> getJobs(@PathVariable("userId") String userId, @PathVariable(value = "operation") String operation){
        return backofficeService.getJobs(userId,operation);
    }
}

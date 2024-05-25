package com.lacon.workflow.controller;


import com.lacon.workflow.model.request.camunda.UpdateVariableRequest;
import com.lacon.workflow.model.response.JobResponse;
import com.lacon.workflow.model.response.SuccessResponse;
import com.lacon.workflow.service.backoffice.BackofficeJobService;
import com.lacon.workflow.service.backoffice.BackofficeService;
import com.lacon.workflow.service.core.SecurityUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class BackofficeController {
    private final BackofficeJobService backofficeJobService;
    private final BackofficeService backofficeService;

    public BackofficeController(BackofficeJobService backofficeJobService, BackofficeService backofficeService) {
        this.backofficeJobService = backofficeJobService;
        this.backofficeService = backofficeService;
    }



    @GetMapping("/backoffice/job/{operation}")
    public List<JobResponse> getJobs(@PathVariable(value = "operation") String operation){
        return backofficeJobService.getJobs(SecurityUtil.currentUserId(),operation);
    }

    @PostMapping("/backoffice/decision")
    public SuccessResponse documentDecision(@RequestBody UpdateVariableRequest request){
        return backofficeService.updateDecision(request);
    }
}

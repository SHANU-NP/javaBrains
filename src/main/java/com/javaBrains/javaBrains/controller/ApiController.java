package com.javaBrains.javaBrains.controller;

import com.javaBrains.javaBrains.model.PolicyRequest;
import com.javaBrains.javaBrains.model.SuccessResponse;
import com.javaBrains.javaBrains.model.quartz.QuartzModel;
import com.javaBrains.javaBrains.service.PolicyService;
import com.javaBrains.javaBrains.service.quartz.QuartzEventHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    private final PolicyService policyService;
    private final QuartzEventHandler quartzEventHandler;

    public ApiController(PolicyService policyService, QuartzEventHandler quartzEventHandler) {
        this.policyService = policyService;
        this.quartzEventHandler = quartzEventHandler;
    }

    @PostMapping("/create/policy")
    public SuccessResponse createPolicy(@RequestBody PolicyRequest request){
        return policyService.createNewPolicy(request);
    }

    @PostMapping("/schedule/report")
    public SuccessResponse scheduleReport(@RequestBody QuartzModel quartzModel){
        quartzEventHandler.scheduleReportJob(quartzModel);
        return new SuccessResponse("Success");

    }
}

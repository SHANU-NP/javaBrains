package com.lacon.workflow.service.camunda;

import com.lacon.workflow.entity.JobStatus;
import com.lacon.workflow.entity.User;
import com.lacon.workflow.model.request.camunda.AssigneeData;
import com.lacon.workflow.service.UserService;
import com.lacon.workflow.service.backoffice.BackofficeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class WorkFlowAssigneeService {

    private final UserService userService;
    private final BackofficeService backofficeService;

    public WorkFlowAssigneeService(UserService userService, BackofficeService backofficeService) {
        this.userService = userService;
        this.backofficeService = backofficeService;
    }

    public AssigneeData getUserByOperation(String operation){
        List<User> users = userService.getUsersByRole(operation);
        Random random = new Random();
        int index = random.nextInt(users.size());
        return new AssigneeData(users.get(index).getCustomerId().toString());
    }

    public void updateJobStatus(JobStatus jobStatus){
        backofficeService.setJobStatus(jobStatus);
    }

}

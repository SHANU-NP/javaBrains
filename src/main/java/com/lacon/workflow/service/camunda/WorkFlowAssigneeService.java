package com.lacon.workflow.service.camunda;

import com.lacon.workflow.entity.JobStatus;
import com.lacon.workflow.entity.User;
import com.lacon.workflow.model.request.camunda.AssigneeData;
import com.lacon.workflow.service.UserService;
import com.lacon.workflow.service.backoffice.BackofficeJobService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class WorkFlowAssigneeService {

    private final UserService userService;
    private final BackofficeJobService backofficeJobService;

    public WorkFlowAssigneeService(UserService userService, BackofficeJobService backofficeJobService) {
        this.userService = userService;
        this.backofficeJobService = backofficeJobService;
    }

    public AssigneeData getUserByOperation(String operation){
        List<User> users = userService.getUsersByRole(operation);
        Random random = new Random();
        int index = random.nextInt(users.size());
        return new AssigneeData(users.get(index).getUserId().toString());
    }

    public void updateJobStatus(JobStatus jobStatus){
        backofficeJobService.setJobStatus(jobStatus);
    }

}

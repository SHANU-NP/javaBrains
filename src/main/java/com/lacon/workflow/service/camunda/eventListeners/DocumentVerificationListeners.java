package com.lacon.workflow.service.camunda.eventListeners;

import com.lacon.workflow.constants.Constants;
import com.lacon.workflow.entity.JobStatus;
import com.lacon.workflow.model.request.camunda.AssigneeData;
import com.lacon.workflow.service.camunda.WorkFlowAssigneeService;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.camunda.bpm.engine.task.IdentityLink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

import static com.lacon.workflow.constants.Constants.JOB_STATUS_PENDING;
import static com.lacon.workflow.constants.Constants.VARIABLE_DOCUMENT_VERIFIER_DECISION;

@Service
public class DocumentVerificationListeners implements TaskListener {
    final Logger log = LoggerFactory.getLogger(SupervisorListener.class);
    private final WorkFlowAssigneeService workFlowAssigneeService;

    public DocumentVerificationListeners(WorkFlowAssigneeService workFlowAssigneeService) {
        this.workFlowAssigneeService = workFlowAssigneeService;
    }

    @Override
    public void notify(DelegateTask delegateTask) {
        String jobId = (String) delegateTask.getVariable(Constants.VARIABLE_JOB_ID);
        String customerId = (String) delegateTask.getVariable(Constants.VARIABLE_CUSTOMER_ID);
        log.info("DOCUMENT VERIFICATION FLOW : document verifier job has been started for job id : {} customerID : {}",jobId,customerId);
        delegateTask.setVariable(VARIABLE_DOCUMENT_VERIFIER_DECISION,JOB_STATUS_PENDING);
        Set<IdentityLink> identityLinks = delegateTask.getCandidates();
        identityLinks.stream().findAny().ifPresent(identityLink -> {
            AssigneeData user = workFlowAssigneeService.getUserByOperation(identityLink.getGroupId());
            delegateTask.setAssignee(user.getUserId());
            delegateTask.setVariable(Constants.VARIABLE_ASSIGNEE, user.getUserId());

            JobStatus jobStatus = new JobStatus();
            jobStatus.setJobId(UUID.fromString(jobId));
            jobStatus.setJobStatus(JOB_STATUS_PENDING);
            jobStatus.setCustomerId(UUID.fromString(customerId));
            jobStatus.setOperation(delegateTask.getTaskDefinitionKey());
            jobStatus.setUserId(UUID.fromString(user.getUserId()));
            jobStatus.setTime(OffsetDateTime.now());
            workFlowAssigneeService.updateJobStatus(jobStatus);

        });
        log.info("DOCUMENT VERIFICATION FLOW : document verifier job has ended for job id : {} customerID : {}",jobId,customerId);


    }
}

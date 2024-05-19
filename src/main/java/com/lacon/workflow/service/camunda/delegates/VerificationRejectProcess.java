package com.lacon.workflow.service.camunda.delegates;

import com.lacon.workflow.constants.Constants;
import com.lacon.workflow.service.CustomerService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class VerificationRejectProcess implements JavaDelegate {
    final Logger log = LoggerFactory.getLogger(VerificationRejectProcess.class);

    private final CustomerService customerService;

    public VerificationRejectProcess(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        String jobId = (String) delegateExecution.getVariable(Constants.VARIABLE_JOB_ID);
        String customerId = (String) delegateExecution.getVariable(Constants.VARIABLE_CUSTOMER_ID);
        log.info("DOCUMENT_VERIFICATION_FLOW: reject document verification for job id : {} and customer id : {}",jobId,customerId);
        customerService.updateDocumentStatus(jobId,Constants.REJECTED);
    }
}

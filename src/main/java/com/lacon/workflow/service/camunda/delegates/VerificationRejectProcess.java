package com.lacon.workflow.service.camunda.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerificationRejectProcess implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        final Logger log = LoggerFactory.getLogger(VerificationRejectProcess.class);
        log.info("enter into VerificationRejectProcess class");
    }
}

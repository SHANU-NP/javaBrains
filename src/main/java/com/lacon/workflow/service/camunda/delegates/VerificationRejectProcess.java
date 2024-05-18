package com.lacon.workflow.service.camunda.delegates;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VerificationRejectProcess implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        final Logger log = LoggerFactory.getLogger(VerificationRejectProcess.class);
        log.info("enter into VerificationRejectProcess class");
    }
}

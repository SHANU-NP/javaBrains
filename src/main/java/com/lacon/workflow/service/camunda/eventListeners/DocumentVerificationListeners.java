package com.lacon.workflow.service.camunda.eventListeners;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DocumentVerificationListeners implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {

        final Logger log = LoggerFactory.getLogger(SupervisorListener.class);
        log.info("enter into DocumentVerificationListeners class");

    }
}

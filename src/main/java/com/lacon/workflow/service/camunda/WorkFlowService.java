package com.lacon.workflow.service.camunda;

import com.lacon.workflow.constants.Constants;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.lacon.workflow.constants.Constants.DOCUMENT_VERIFICATION_PROCESS_DEFINITION_KEY;
import static com.lacon.workflow.constants.Constants.EVENT_DOCUMENT_VERIFICATION;

@Service
public class WorkFlowService {
private static final Logger log = LoggerFactory.getLogger(WorkFlowService.class);

    public void initiateDocumentVerificationFlow(String jobId,String customerId){

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery().processDefinitionKey(DOCUMENT_VERIFICATION_PROCESS_DEFINITION_KEY)
                .processInstanceBusinessKey(jobId).active().list();
        if (processInstances.isEmpty()){
            Map<String, Object> variables = new HashMap<>();
            variables.put(Constants.VARIABLE_JOB_ID,jobId);
            variables.put(Constants.VARIABLE_EVENT, Constants.EVENT_DOCUMENT_VERIFICATION);
            variables.put(Constants.VARIABLE_CUSTOMER_ID,customerId);
            runtimeService.startProcessInstanceByKey(DOCUMENT_VERIFICATION_PROCESS_DEFINITION_KEY, jobId,variables);
            log.info("<---------------DOCUMENT VERIFICATION FLOW : new process started for job id : {} event : {} ------------->",jobId,EVENT_DOCUMENT_VERIFICATION);
        }

    }
}

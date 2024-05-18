package com.lacon.workflow.service.camunda;

import com.lacon.workflow.constants.Constants;
import com.lacon.workflow.entity.JobStatus;
import com.lacon.workflow.model.request.camunda.UpdateVariableRequest;
import com.lacon.workflow.model.request.camunda.VariableModel;
import com.lacon.workflow.repository.BackofficeJobStatusRepository;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.lacon.workflow.constants.Constants.*;

@Service
public class WorkFlowService {
private static final Logger log = LoggerFactory.getLogger(WorkFlowService.class);
private final BackofficeJobStatusRepository backofficeJobStatusRepository;

    public WorkFlowService(BackofficeJobStatusRepository backofficeJobStatusRepository) {
        this.backofficeJobStatusRepository = backofficeJobStatusRepository;
    }

    public void initiateDocumentVerificationFlow(String jobId,String customerId) {

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        List<ProcessInstance> processInstances = runtimeService.createProcessInstanceQuery().processDefinitionKey(DOCUMENT_VERIFICATION_PROCESS_DEFINITION_KEY)
                .processInstanceBusinessKey(jobId).active().list();
        if (processInstances.isEmpty()) {
            Map<String, Object> variables = new HashMap<>();
            variables.put(VARIABLE_JOB_ID, jobId);
            variables.put(Constants.VARIABLE_EVENT, Constants.EVENT_DOCUMENT_VERIFICATION);
            variables.put(Constants.VARIABLE_CUSTOMER_ID, customerId);
            runtimeService.startProcessInstanceByKey(DOCUMENT_VERIFICATION_PROCESS_DEFINITION_KEY, jobId, variables);
            log.info("<---------------DOCUMENT VERIFICATION FLOW : new process started for job id : {} event : {} ------------->", jobId, EVENT_DOCUMENT_VERIFICATION);
        }

    }


    public void updateVariables(String operation, UpdateVariableRequest updateVariableRequest){

        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        ProcessInstance processInstances = runtimeService.createProcessInstanceQuery().processDefinitionKey(DOCUMENT_VERIFICATION_PROCESS_DEFINITION_KEY)
                .variableValueEquals(VARIABLE_JOB_ID,updateVariableRequest.getJobId()).active().singleResult();

        //update variables
        for (VariableModel variableModel : updateVariableRequest.getVariableList()) {
            runtimeService.setVariable(processInstances.getProcessInstanceId(), variableModel.getKey(), variableModel.getValue());
            log.info("<------------DOCUMENT VERIFICATION FLOW : Variables updated key : {} , value : {}  : jobId : {} --------------->"
                    ,variableModel.getKey(),variableModel.getValue(),updateVariableRequest.getJobId());
        }

        //complete the task
        TaskService taskService = processEngine.getTaskService();
        List<Task> tasks = taskService.createTaskQuery().processVariableValueEquals(Constants.VARIABLE_JOB_ID,updateVariableRequest.getJobId()).active().list();
        for (Task task : tasks) {
            for (VariableModel variableModel : updateVariableRequest.getVariableList()){
                if (variableModel.getKey().equals(VARIABLE_DOCUMENT_VERIFIER_DECISION) && task.getTaskDefinitionKey().equals(ROLE_DOCUMENT_VERIFIER)){
                    completeTheTaskById(task.getId());
                }else if (variableModel.getKey().equals(VARIABLE_SUPERVISOR_DECISION) && task.getTaskDefinitionKey().equals(ROLE_SUPER_VISOR)){
                    completeTheTaskById(task.getId());
                }
            }

        }
    }




    //complete the task by task id
    public void completeTheTaskById(String id){
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        TaskService taskService = processEngine.getTaskService();
        Task task = taskService.createTaskQuery().taskId(id).singleResult();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        runtimeService.setVariable(task.getProcessInstanceId(),Constants.VARIABLE_PREV_TASK_ASSIGNEE , task.getAssignee());

        String jobId = (String) runtimeService.getVariable(task.getProcessInstanceId(), Constants.VARIABLE_JOB_ID);
        String customerId = (String) runtimeService.getVariable(task.getProcessInstanceId(),Constants.VARIABLE_CUSTOMER_ID);
        String operation = task.getTaskDefinitionKey();

        JobStatus jobStatus = new JobStatus();
        jobStatus.setJobStatus(END);
        jobStatus.setJobId(UUID.fromString(jobId));
        jobStatus.setTime(OffsetDateTime.now());
        jobStatus.setCustomerId(UUID.fromString(customerId));
        jobStatus.setOperation(operation);
        backofficeJobStatusRepository.save(jobStatus);

        taskService.complete(id);
    }
}

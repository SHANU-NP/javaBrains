package com.lacon.workflow.service.backoffice;

import com.lacon.workflow.constants.Constants;
import com.lacon.workflow.model.request.camunda.UpdateVariableRequest;
import com.lacon.workflow.model.response.SuccessResponse;
import com.lacon.workflow.service.camunda.WorkFlowService;
import org.springframework.stereotype.Service;

@Service
public class BackofficeService {

    private final WorkFlowService workFlowService;

    public BackofficeService(WorkFlowService workFlowService) {
        this.workFlowService = workFlowService;
    }

    public SuccessResponse updateDecision(UpdateVariableRequest request) {
        workFlowService.updateVariables(request);
        return new SuccessResponse(Constants.DECISION_SUBMISSION_SUCCESS_FULL);
    }
}

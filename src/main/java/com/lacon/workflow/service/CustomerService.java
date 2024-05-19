package com.lacon.workflow.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lacon.workflow.constants.Constants;
import com.lacon.workflow.entity.CustomerDocumentDetails;
import com.lacon.workflow.model.request.DocumentVerificationRequest;
import com.lacon.workflow.model.response.CustomerDocumentDetailsResponse;
import com.lacon.workflow.model.response.SuccessResponse;
import com.lacon.workflow.repository.CustomerDocumentDetailRepository;
import com.lacon.workflow.service.camunda.WorkFlowService;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static com.lacon.workflow.constants.Constants.JOB_STATUS_PENDING;

@Service
public class CustomerService {

    private final CustomerDocumentDetailRepository customerDocumentDetailRepository;
    private final ObjectMapper objectMapper;
    private final WorkFlowService workFlowService;

    public CustomerService(CustomerDocumentDetailRepository customerDocumentDetailRepository, ObjectMapper objectMapper, WorkFlowService workFlowService) {
        this.customerDocumentDetailRepository = customerDocumentDetailRepository;
        this.objectMapper = objectMapper;
        this.workFlowService = workFlowService;
    }


    public SuccessResponse documentVerificationRequestInitiate(DocumentVerificationRequest documentVerificationRequest) throws JsonProcessingException {
        CustomerDocumentDetails documentDetails = new CustomerDocumentDetails();
        documentDetails.setCustomerId(UUID.randomUUID());
        documentDetails.setJobStatus(JOB_STATUS_PENDING);
        documentDetails.setDocumentDetails(objectMapper.writeValueAsString(documentVerificationRequest));
        documentDetails.setJobId(UUID.randomUUID());
        customerDocumentDetailRepository.save(documentDetails);
        //initiate work flow
        workFlowService.initiateDocumentVerificationFlow(documentDetails.getJobId().toString(),documentDetails.getCustomerId().toString());
        return new SuccessResponse(Constants.DOCUMENT_SUBMISSION_SUCCESSFUL);

    }

    public void updateDocumentStatus(String jobId,String status) {
        CustomerDocumentDetails documentDetails = customerDocumentDetailRepository.findByJobId(UUID.fromString(jobId));
        documentDetails.setJobStatus(status);
        customerDocumentDetailRepository.save(documentDetails);
    }

    public CustomerDocumentDetailsResponse getCustomerDocumentDetails(String customerId) throws JsonProcessingException {
        CustomerDocumentDetails documentDetails = customerDocumentDetailRepository.findByCustomerId(UUID.fromString(customerId));
        if (documentDetails == null){
            return null;
        }

        CustomerDocumentDetailsResponse response = new CustomerDocumentDetailsResponse();
        response.setJobId(documentDetails.getJobId().toString());
        response.setStatus(documentDetails.getJobStatus());
        response.setDocumentDetails(objectMapper.readValue(documentDetails.getDocumentDetails(), new TypeReference<>() {}));
        return response;
    }
}

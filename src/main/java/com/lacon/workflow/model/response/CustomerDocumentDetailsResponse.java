package com.lacon.workflow.model.response;

import com.lacon.workflow.model.request.DocumentVerificationRequest;
import lombok.Data;

@Data
public class CustomerDocumentDetailsResponse {

    private String jobId;
    private DocumentVerificationRequest documentDetails;
    private String status;

}

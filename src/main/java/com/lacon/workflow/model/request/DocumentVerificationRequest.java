package com.lacon.workflow.model.request;

import lombok.Data;

@Data
public class DocumentVerificationRequest {

    private String nameOfApplicant;
    private String nameOfProject;
    private String organicCertificationUserName;
    private String registrationNumber;
    private String licenseNumber;
    private String address;
}

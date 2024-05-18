package com.lacon.workflow.model.request;

import lombok.Data;

@Data
public class RegistrationRequest {

    private String firstName;
    private String lastName;
    private String phone;
    private String password;
    private String role;

}

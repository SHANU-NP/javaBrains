package com.lacon.workflow.model.response;

import lombok.Data;

import java.util.List;

@Data
public class RoleResponse {

    private List<String> roles;

    public RoleResponse(List<String> roleCustomer) {
        this.roles = roleCustomer;
    }
}

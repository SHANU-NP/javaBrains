package com.lacon.workflow.model.request.camunda;

import lombok.Data;

@Data
public class VariableModel {

    private String key;

    private Object value;
}

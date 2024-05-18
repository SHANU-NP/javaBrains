package com.lacon.workflow.model.request.camunda;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UpdateVariableRequest implements Serializable{

    private String jobId;

    List<VariableModel> variableList;
}

package com.lacon.workflow.constants;

public class Constants {



    private Constants() {}

    public static final String DOCUMENT_VERIFICATION_PROCESS_DEFINITION_KEY = "DOCUMENT_VERIFICATION_FLOW";

    //camunda variables
    public static final String VARIABLE_JOB_ID = "JOB_ID";
    public static final String VARIABLE_EVENT = "EVENT";
    public static final String EVENT_DOCUMENT_VERIFICATION = "DOCUMENT_VERIFICATION";
    public static final String VARIABLE_CUSTOMER_ID = "CUSTOMER_ID";
    public static final String VARIABLE_PREV_TASK_ASSIGNEE = "prevTaskAssignee";
    public static final String VARIABLE_DOCUMENT_VERIFIER_DECISION = "documentDecision";
    public static final String VARIABLE_SUPERVISOR_DECISION = "supervisorDecision";

    public static final String VARIABLE_ASSIGNEE = "assignee";

    //decision
    public static final String END = "END";
    public static final String APPROVED = "APPROVED";
    public static final String REJECTED = "REJECTED";

    //roles
    public static final String ROLE_CUSTOMER = "CUSTOMER";
    public static final String ROLE_DOCUMENT_VERIFIER = "DOCUMENT_VERIFIER";
    public static final String ROLE_SUPER_VISOR = "SUPER_VISOR";
    public static final String JOB_STATUS_PENDING = "PENDING";

    //messages
    public static final String DOCUMENT_SUBMISSION_SUCCESSFUL = "Document submitted successfully";
    public static final String REGISTRATION_SUCCESS = "Registration is successful";
    public static final String DECISION_SUBMISSION_SUCCESS_FULL = "Submitted successfully";
    public static final String INVALID_CREDENTIALS = "invalid username or password";


}

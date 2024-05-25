package com.lacon.workflow.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "backoffice_comment_history")
@AllArgsConstructor
@NoArgsConstructor
public class BackOfficeCommentHistory extends DBTimeStamp{

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    private Long id;

    @Column(name = "job_id")
    private UUID jobId;

    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "operation")
    private String operation;

    @Column(name = "user_Id")
    private UUID userId;

    @Column(name = "comment",columnDefinition = "text")
    private String comment;

    @Column(name = "comment_id")
    private UUID commentId;

}

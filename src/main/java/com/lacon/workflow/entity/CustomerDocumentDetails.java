package com.lacon.workflow.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "customer_document_details")
public class CustomerDocumentDetails extends DBTimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    @Column(name = "customer_id")
    private UUID customerId;

    @Column(name = "job_id")
    private UUID jobId;

    @Column(name = "job_status")
    private String jobStatus;

    @Column(name = "document_details",columnDefinition = "TEXT")
    private String documentDetails;

}

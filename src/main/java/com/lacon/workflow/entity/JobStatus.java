package com.lacon.workflow.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "job_status")
@AllArgsConstructor
@NoArgsConstructor
public class JobStatus extends DBTimeStamp{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    private Long id;

    @Getter
    @Setter
    @Column(name = "customer_id")
    private UUID customerId;

    @Getter
    @Setter
    @Column(name = "job_id")
    private UUID jobId;

    @Getter
    @Setter
    @Column(name = "user_id")
    private UUID userId;

    @Getter
    @Setter
    @Column(name = "operation")
    private String operation;

    @Getter
    @Setter
    @Column(name = "job_status")
    private String jobStatus;

    @Setter
    @Getter
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssX")
    private OffsetDateTime time;
}

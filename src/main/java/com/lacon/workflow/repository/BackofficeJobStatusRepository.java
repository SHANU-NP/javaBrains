package com.lacon.workflow.repository;

import com.lacon.workflow.entity.JobStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BackofficeJobStatusRepository extends JpaRepository<JobStatus,Long> {
    List<JobStatus> findByOperationAndUserId(String operation, UUID userId);
    JobStatus findByOperationAndJobId(String operation,UUID userId);

}

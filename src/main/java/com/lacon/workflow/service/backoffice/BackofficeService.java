package com.lacon.workflow.service.backoffice;

import com.lacon.workflow.entity.JobStatus;
import com.lacon.workflow.model.response.JobResponse;
import com.lacon.workflow.repository.BackofficeJobStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BackofficeService {

    private final BackofficeJobStatusRepository jobStatusRepository;

    public BackofficeService(BackofficeJobStatusRepository jobStatusRepository) {
        this.jobStatusRepository = jobStatusRepository;
    }

    public List<JobResponse> getJobs(String userId, String operation) {
        List<JobStatus> jobs = jobStatusRepository.findByOperationAndUserId(operation, UUID.fromString(userId));
        return jobs.stream().map(job -> {
            JobResponse jobResponse = new JobResponse();
            jobResponse.setJobId(job.getJobId().toString());
            jobResponse.setCustomerId(job.getCustomerId().toString());
            jobResponse.setJobStatus(job.getJobStatus());
            return jobResponse;
        }).collect(Collectors.toList());
    }
}

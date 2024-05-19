package com.lacon.workflow.service.backoffice;

import com.lacon.workflow.entity.JobStatus;
import com.lacon.workflow.model.response.JobResponse;
import com.lacon.workflow.repository.BackofficeJobStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BackofficeJobService {

    private final BackofficeJobStatusRepository jobStatusRepository;

    public BackofficeJobService(BackofficeJobStatusRepository jobStatusRepository) {
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

    //set job status
    public void setJobStatus(JobStatus jobStatus) {
        JobStatus job = jobStatusRepository.findByOperationAndJobId(jobStatus.getOperation(), jobStatus.getJobId());
        if (job == null)
            jobStatusRepository.save(jobStatus);
        else {
            job.setJobStatus(jobStatus.getJobStatus());
            job.setUserId(jobStatus.getUserId());
            job.setTime(jobStatus.getTime());
            jobStatusRepository.save(jobStatus);
        }
    }

}

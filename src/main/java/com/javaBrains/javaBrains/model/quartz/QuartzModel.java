package com.javaBrains.javaBrains.model.quartz;

import lombok.Getter;
import lombok.Setter;
import org.quartz.Job;
import org.quartz.JobDataMap;

import java.time.OffsetDateTime;

@Setter
@Getter
public class QuartzModel {

    JobDataMap jobDataMap;
    String jobName;
    String jobGroup;
    String jobDescription;
    String triggerName;
    String triggerGroup;
    String triggerDescription;
    Class<? extends Job> quartzJobBean;
    OffsetDateTime startAt;

}

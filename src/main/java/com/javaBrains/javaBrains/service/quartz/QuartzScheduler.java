package com.javaBrains.javaBrains.service.quartz;

import com.javaBrains.javaBrains.model.quartz.QuartzModel;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component("QuartzSchedulerBean")
public class QuartzScheduler {
    private static final Logger log = LoggerFactory.getLogger(QuartzScheduler.class);

        private final Scheduler scheduler;

    public QuartzScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void scheduleJob(QuartzModel quartzModel) throws SchedulerException {
        JobDetail jobDetail = buildJob(quartzModel);
        Trigger trigger = buildTrigger(quartzModel,jobDetail);
        log.info("<------- quartz scheduler is going to schedule a job ------------>");
        scheduler.scheduleJob(jobDetail,trigger);
    }



    private JobDetail buildJob(QuartzModel quartzModel) {
        log.info("------ Build job entered-------------");
        return JobBuilder.newJob(quartzModel.getQuartzJobBean())
                .withIdentity(UUID.randomUUID()+quartzModel.getJobName(),quartzModel.getJobGroup())
                .withDescription(quartzModel.getJobDescription())
                .setJobData(quartzModel.getJobDataMap())
                .build();
    }


    private Trigger buildTrigger(QuartzModel quartzModel, JobDetail jobDetail) {
        log.info("------ Build trigger entered-------------");
            return TriggerBuilder.newTrigger()
                    .forJob(jobDetail)
                    .withIdentity(UUID.randomUUID() +quartzModel.getTriggerName(), quartzModel.getTriggerGroup())
                    .withDescription(quartzModel.getTriggerDescription())
                    .startAt(Date.from(quartzModel.getStartAt().toInstant()))
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInMinutes(1).repeatForever())
                    .build();
    }

}

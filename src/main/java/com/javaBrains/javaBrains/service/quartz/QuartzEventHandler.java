package com.javaBrains.javaBrains.service.quartz;

import com.javaBrains.javaBrains.model.quartz.QuartzModel;
import com.javaBrains.javaBrains.service.quartz.quartzBean.ReportExportJob;
import org.quartz.JobDataMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class QuartzEventHandler {
    private static final Logger log = LoggerFactory.getLogger(QuartzEventHandler.class);

    private final QuartzScheduler quartzScheduler;

    public QuartzEventHandler(QuartzScheduler quartzScheduler) {
        this.quartzScheduler = quartzScheduler;
    }

    public void scheduleReportJob(QuartzModel quartzModel) {

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("reportName","java export");
        quartzModel.setJobDataMap(jobDataMap);
        quartzModel.setStartAt(OffsetDateTime.now());
        quartzModel.setQuartzJobBean(ReportExportJob.class);
        try {
            quartzScheduler.scheduleJob(quartzModel);
        }catch (Exception e){
            log.info("Exception :- exception occurred while scheduling job ====================>");
            e.fillInStackTrace();
        }


    }
}

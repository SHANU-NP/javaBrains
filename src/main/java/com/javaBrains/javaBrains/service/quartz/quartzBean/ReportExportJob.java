package com.javaBrains.javaBrains.service.quartz.quartzBean;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

@Component
public class ReportExportJob extends QuartzJobBean {



    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        JobDataMap jobDataMap = jobExecutionContext.getMergedJobDataMap();
        System.out.println("job execution started at :"+new Date());
        System.out.println(jobDataMap.getString("reportName"));
        System.out.println("job execution ended at :"+new Date());

    }
}

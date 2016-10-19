package com.jobscheduler.dashboard.controller;

import com.jobscheduler.dashboard.model.Job;
import com.jobscheduler.dashboard.service.JobService;
import com.jobscheduler.dashboard.service.TriggerService;
import com.jobscheduler.dashboard.utils.ReturnTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * JobController :
 *
 * @author wuhuachuan712@163.com
 * @date 16/10/9
 */

@Slf4j
@RestController
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private TriggerService triggerService;

    @RequestMapping(value = "/jobs",method = RequestMethod.GET)
    public Object findTriggers(){

        List<Job> jobs = jobService.findJobs();
        jobs.parallelStream().forEach(
            job ->{
                job.getTriggerList().addAll(triggerService.findTriggerByJobName(job.getJobName()));
            }
        );

        return new ReturnTemplate(jobs);
    }

    @RequestMapping(value = "/job/{jobName}",method = RequestMethod.GET)
    public Object findTrigger(@PathVariable(name = "jobName") final String jobName){
        log.info("jobName = {}.",jobName);

        if(!StringUtils.hasText(jobName)){
            throw new IllegalArgumentException("jobName is invalid");
        }

        Job job = jobService.findJobByJobName(jobName);
        job.getTriggerList().addAll(triggerService.findTriggerByJobName(job.getJobName()));

        return new ReturnTemplate(job);
    }
}

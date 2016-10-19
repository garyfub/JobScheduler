package com.jobscheduler.dashboard.service;

import com.jobscheduler.dashboard.model.Job;

import java.util.List;

/**
 * JobService :
 *
 * @author wuhuachuan712@163.com
 * @date 16/10/9
 */
public interface JobService {
    List<Job> findJobs();

    Job findJobByJobName(final String jobName);
}

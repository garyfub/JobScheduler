package com.jobscheduler.dashboard.serviceImpl;

import com.jobscheduler.dashboard.dao.JobDao;
import com.jobscheduler.dashboard.model.Job;
import com.jobscheduler.dashboard.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * JobServiceImpl :
 *
 * @author wuhuachuan712@163.com
 * @date 16/10/9
 */

@Service
public class JobServiceImpl implements JobService {

    @Autowired
    private JobDao jobDao;

    @Override
    public List<Job> findJobs() {
        return jobDao.findAll();
    }

    @Override
    public Job findJobByJobName(String jobName) {
        return jobDao.findJobByJobName(jobName);
    }
}

package com.jobscheduler.dashboard.serviceImpl;

import com.jobscheduler.dashboard.dao.JobDao;
import com.jobscheduler.dashboard.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
